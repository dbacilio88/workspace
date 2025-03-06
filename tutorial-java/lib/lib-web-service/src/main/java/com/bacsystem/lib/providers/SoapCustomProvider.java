package com.bacsystem.lib.providers;

import com.bacsystem.lib.components.base.SoapBase;
import com.bacsystem.lib.components.enums.ValidateResult;
import com.bacsystem.lib.components.exceptions.SoapProcessException;
import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapCustomDefinition;
import com.bacsystem.lib.components.factories.abstracts.mappers.ISoapRequestMapper;
import com.bacsystem.lib.components.factories.abstracts.mappers.ISoapResponseMapper;
import com.bacsystem.lib.components.factories.abstracts.request.SoapRequest;
import com.bacsystem.lib.components.factories.abstracts.response.SoapResponse;
import com.bacsystem.lib.components.factories.services.ISoapService;
import com.bacsystem.lib.dto.SoapValidationResult;
import com.bacsystem.lib.providers.request.RequestProvider;
import com.bacsystem.lib.providers.response.ResponseProvider;
import com.bacsystem.lib.providers.validations.ISoapCustomDefinitionValidation;
import com.bacsystem.lib.providers.validations.ISoapRequestProviderValidation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.bacsystem.lib.constants.CommonSoapConstants.*;


/**
 * <b>SoapCustomProvider</b>
 * <p>
 * This class specifies the requirements for the {@link SoapCustomProvider} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Proveedor de servicios personalizados de SOAP. Esta clase implementa la interfaz ISoapCustomProvider y gestiona la lógica para llamar a servicios SOAP utilizando definiciones personalizadas y validaciones de solicitud y respuesta.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
@Component(value = SOAP_CUSTOM_PROVIDER_IDENTIFICATION)
public class SoapCustomProvider extends SoapBase implements ISoapCustomProvider {

    private final ISoapService soapService;

    public SoapCustomProvider(final ISoapService soapService) {
        super(SoapCustomProvider.class.getSimpleName());
        this.soapService = soapService;
    }

    /**
     * Llama a un servicio utilizando un proveedor de solicitudes y una definición personalizada.
     *
     * @param request          El proveedor de solicitudes que contiene los datos necesarios para la llamada.
     * @param customDefinition La definición personalizada que especifica cómo debe manejarse la solicitud.
     * @param <S>              El tipo de la solicitud.
     * @param <T>              El tipo de la respuesta.
     * @return Un objeto {@link ResponseProvider} que contiene la respuesta del servicio.
     */

    @Override
    public <S, T> ResponseProvider<T> callService(RequestProvider<S, T> request, ISoapCustomDefinition customDefinition) {
        validateSoapRequestProvider(request);
        validateSoapCustomDefinition(request, customDefinition);
        T currentRequest = soapMapperRequest(request, customDefinition);
        validateSoapRequest(currentRequest, customDefinition);
        T response = callSoap(request, customDefinition);
        validateSoapResponse(response, customDefinition);
        T currentResponse = soapMapperResponse(response, customDefinition);
        log.debug(SOAP_COMMON_SUCCESS_DO_ON_PROCESS_FORMAT, "callService", currentResponse);
        return returnSoap(currentResponse, request);
    }

    private <S, T> void validateSoapRequestProvider(final RequestProvider<S, T> request) {
        log.debug("validate request provider {}", request);
        final SoapValidationResult result = ISoapRequestProviderValidation.validation().apply(request);
        if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error("validation request provider failed");
            throw new SoapProcessException("validation request provider failed");
        }
    }

    private <S, T> void validateSoapCustomDefinition(final RequestProvider<S, T> request, ISoapCustomDefinition customDefinition) {
        log.debug("validate request {} and definition {}", request, customDefinition);
        final SoapValidationResult result = ISoapCustomDefinitionValidation.validation().apply(customDefinition);
        if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error("validation standard definition failed");
            throw new SoapProcessException("validation request failed");
        }
    }

    private <S, T> T soapMapperRequest(final RequestProvider<S, T> request, final ISoapCustomDefinition customDefinition) {
        log.debug("mapper request {}, definition {}", request, customDefinition);
        ISoapRequestMapper<S, T> mapper = customDefinition.toSoapMapperRequest();
        return mapper.map(request.getRequest());
    }

    private <S, T> T soapMapperResponse(final S response, final ISoapCustomDefinition customDefinition) {
        log.debug("mapper response {}, definition {}", response, customDefinition);
        ISoapResponseMapper<S, T> mapper = customDefinition.toSoapMapperResponse();
        return mapper.map(response);
    }

    private <S> void validateSoapRequest(final S request, final ISoapCustomDefinition customDefinition) {
        log.debug("validate request {}, definition {}", request, customDefinition);
        SoapValidationResult result = customDefinition.soapRequestValidation().validateRequest(request);
        if (Objects.nonNull(result) && ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error("validation request failed");
            throw new SoapProcessException("validation request failed");
        }
    }

    private <T> void validateSoapResponse(final T response, final ISoapCustomDefinition customDefinition) {
        log.debug("validate response {}, definition {}", response, customDefinition);
        SoapValidationResult result = customDefinition.soapResponseValidation().validateResponse(response);
        if (Objects.nonNull(result) && ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error(SOAP_COMMON_ERROR_DO_ON_PROCESS_FORMAT, "validateSoapResponse", "validation response failed");
            throw new SoapProcessException("validation response failed");
        }
    }

    private <S, T> T callSoap(final RequestProvider<S, T> request, ISoapCustomDefinition customDefinition) {
        log.debug("call web service, request {}, definition {}", request, customDefinition);
        final SoapRequest<S> currentRequest = customDefinition.soapRequest(request.getRequest());
        final SoapResponse<T> currentResponse = this.soapService.call(customDefinition.soapRequest(currentRequest));
        return currentResponse.getResponse();
    }

    private <S, T> ResponseProvider<T> returnSoap(final T response, final RequestProvider<S, T> request) {
        return ResponseProvider.<T>builder()
                .response(response)
                .definition(request.getDefinition())
                .build();
    }
}

