package com.bacsystem.lib.providers;

import com.bacsystem.lib.components.base.SoapBase;
import com.bacsystem.lib.components.enums.ValidateResult;
import com.bacsystem.lib.components.exceptions.SoapProcessException;
import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapStandardDefinition;
import com.bacsystem.lib.components.factories.abstracts.response.SoapResponse;
import com.bacsystem.lib.components.factories.services.ISoapService;
import com.bacsystem.lib.dto.SoapValidationResult;
import com.bacsystem.lib.providers.request.RequestProvider;
import com.bacsystem.lib.providers.response.ResponseProvider;
import com.bacsystem.lib.providers.validations.ISoapRequestProviderValidation;
import com.bacsystem.lib.providers.validations.ISoapStandardDefinitionValidation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static com.bacsystem.lib.constants.CommonSoapConstants.SOAP_STANDARD_PROVIDER_IDENTIFICATION;
import static com.bacsystem.lib.constants.CommonSoapConstants.SOAP_SUPPRESS_WARNINGS_UNCHECKED;

/**
 * <b>SoapStandardProvider</b>
 * <p>
 * This class specifies the requirements for the {@link SoapStandardProvider} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Proveedor de servicios estándar de SOAP. Esta clase implementa la interfaz ISoapStandardProvider y gestiona la lógica para llamar a servicios SOAP utilizando definiciones estándar y validaciones de solicitud y respuesta.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
@SuppressWarnings(SOAP_SUPPRESS_WARNINGS_UNCHECKED)
@Component(value = SOAP_STANDARD_PROVIDER_IDENTIFICATION)
public class SoapStandardProvider extends SoapBase implements ISoapStandardProvider {

    private final ISoapService soapService;

    public SoapStandardProvider(final ISoapService soapService) {
        super(SoapStandardProvider.class.getSimpleName());
        this.soapService = soapService;
    }

    /**
     * Llama a un servicio utilizando un proveedor de solicitudes y una definición estándar.
     *
     * @param request            El proveedor de solicitudes que contiene los datos necesarios para la llamada.
     * @param standardDefinition La definición estándar que especifica cómo debe manejarse la solicitud.
     * @param <T>                El tipo de la solicitud.
     * @param <R>                El tipo de la respuesta.
     * @return Un objeto {@link ResponseProvider} que contiene la respuesta del servicio.
     */
    @Override
    public <T, R> ResponseProvider<R> callService(RequestProvider<T, R> request, ISoapStandardDefinition standardDefinition) {
        // Validar el RequestProvider
        validateRequestProvider(request);
        // Validar la definición estándar
        validateStandardDefinition(standardDefinition);

        // Validar la solicitud
        validateSoapRequest(request.getRequest(), standardDefinition);

        // Llamar al servicio SOAP
        R soapResponse = callSoapService(request.getRequest(), standardDefinition);

        // Validar la respuesta
        validateResponse(soapResponse, standardDefinition);

        // Construir y devolver la respuesta
        return buildResponse(soapResponse, request);
    }

    /**
     * Llama a un servicio de manera reactiva utilizando un proveedor de solicitudes y una definición estándar.
     *
     * @param request            El proveedor de solicitudes que contiene los datos necesarios para la llamada.
     * @param standardDefinition La definición estándar que especifica cómo debe manejarse la solicitud.
     * @param <T>                El tipo de la solicitud.
     * @param <R>                El tipo de la respuesta.
     * @return Un Mono que envuelve un objeto {@link ResponseProvider} que contiene la respuesta del servicio.
     */
    @Override
    public <T, R> Mono<ResponseProvider<R>> doOnCallService(RequestProvider<T, R> request, ISoapStandardDefinition standardDefinition) {
        return Mono.just(request)
                .flatMap(currentRequestProvider -> doOnValidateRequestProvider(currentRequestProvider)
                        .flatMap(validRequestProvider -> doOnValidateStandardDefinition(standardDefinition)
                                .flatMap(validDefinition -> doOnValidateRequest(validRequestProvider.getRequest(), validDefinition)
                                        .flatMap(validatedRequest -> doOnCallSoapService(validatedRequest, validDefinition)
                                                .flatMap(soapResponse -> doOnValidateResponse(soapResponse, validDefinition)
                                                        .flatMap(validatedResponse -> doOnBuildResponse((R) validatedResponse, request)))))));
    }


    private <S, T> void validateRequestProvider(final RequestProvider<S, T> request) {
        log.debug("step 1: validating soap request provider: request {}", request);
        final SoapValidationResult result = ISoapRequestProviderValidation.validation().apply(request);
        if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error("validation request provider failed");
            throw new SoapProcessException("validation request provider failed");
        }
        log.debug("step 1: validate passed soap request provider: request {}", request);
    }

    private <T, R> Mono<RequestProvider<T, R>> doOnValidateRequestProvider(RequestProvider<T, R> request) {
        log.debug("step 1: validating asynchronous soap request provider: request {}", request);
        return Mono.just(request).flatMap(trRequestProvider -> Mono.just(ISoapRequestProviderValidation.validation())
                .flatMap(iSoapRequestProviderValidation -> {
                    final SoapValidationResult validation = iSoapRequestProviderValidation.apply(trRequestProvider);
                    if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(validation.getValidateResult())) {
                        return Mono.error(() -> new SoapProcessException("Validation request provider failed"));
                    }
                    log.debug("step 1: valid passed asynchronous soap request provider: request {}", request);
                    return Mono.just(trRequestProvider);
                }));
    }

    private void validateStandardDefinition(ISoapStandardDefinition standardDefinition) {
        log.debug("step 2: validating soap standard definition: definition {}", standardDefinition);
        final SoapValidationResult result = ISoapStandardDefinitionValidation.validation().apply(standardDefinition);
        if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error("validation standard definition failed");
            throw new SoapProcessException("validation request failed");
        }
        log.debug("step 2: validate passed soap standard definition: definition {}", standardDefinition);
    }

    private Mono<ISoapStandardDefinition> doOnValidateStandardDefinition(ISoapStandardDefinition standardDefinition) {
        log.debug("step 2: validating asynchronous soap standard definition: definition {}", standardDefinition);
        return Mono.just(standardDefinition).flatMap(iSoapStandardDefinition -> Mono.just(ISoapStandardDefinitionValidation.validation())
                .flatMap(iSoapStandardDefinitionValidation -> {
                    final SoapValidationResult validation = iSoapStandardDefinitionValidation.apply(standardDefinition);
                    if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(validation.getValidateResult())) {
                        return Mono.error(() -> new SoapProcessException("Validation standard definition failed"));
                    }
                    log.debug("step 2: valid passed asynchronous soap standard definition: definition {}", standardDefinition);
                    return Mono.just(standardDefinition);
                }));
    }

    private <T> void validateSoapRequest(final T request, final ISoapStandardDefinition standardDefinition) {
        log.debug("step 3: validating soap request: request {}, definition {}", request, standardDefinition);
        SoapValidationResult result = standardDefinition.soapRequestValidation().validateRequest(request);
        if (Objects.nonNull(result) && ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error("validation request failed");
            throw new SoapProcessException("validation request failed");
        }
        log.debug("step 3: valid passed soap request: request {}, definition {}", request, standardDefinition);
    }

    private <T> Mono<T> doOnValidateRequest(T request, ISoapStandardDefinition standardDefinition) {
        log.debug("step 3: validating asynchronous soap request: request {}, definition {}", request, standardDefinition);
        return Mono.just(request).flatMap(t -> Mono.just(standardDefinition.soapRequestValidation())
                .flatMap(objectISoapRequestValidation -> {
                    final SoapValidationResult validation = objectISoapRequestValidation.validateRequest(request);
                    if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(validation.getValidateResult())) {
                        return Mono.error(() -> new SoapProcessException("Validation request failed"));
                    }
                    log.debug("step 3: valid passed asynchronous soap request: request {}, definition {}", request, standardDefinition);
                    return Mono.just(request);
                }));
    }

    private <T, R> R callSoapService(final T request, ISoapStandardDefinition standardDefinition) {
        log.debug("step 4: call web service: request {}, definition {}", request, standardDefinition);
        final SoapResponse<R> currentResponse = this.soapService.call(standardDefinition.soapRequest(request));
        log.debug("currentResponse T {}", currentResponse);
        log.debug("step 4: call success web service: request {}, definition {}", request, standardDefinition);
        return currentResponse.getResponse();
    }

    private <T, R> Mono<SoapResponse<R>> doOnCallSoapService(T request, ISoapStandardDefinition standardDefinition) {
        log.debug("step 4: call asynchronous web service: request {}, definition {}", request, standardDefinition);
        return Mono.just(standardDefinition.soapRequest(request))
                .flatMap(this.soapService::doOnCall);
    }

    private <R> void validateResponse(final R response, final ISoapStandardDefinition standardDefinition) {
        log.debug("step 5: validating soap response: response {}, definition {}", response, standardDefinition);
        SoapValidationResult result = standardDefinition.soapResponseValidation().validateResponse(response);
        if (Objects.nonNull(result) && ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error("validation response failed");
            throw new SoapProcessException("validation response failed");
        }
        log.debug("step 5: valid passed soap response: response {}, definition {}", response, standardDefinition);
    }

    private <R> Mono<R> doOnValidateResponse(R response, ISoapStandardDefinition standardDefinition) {
        log.debug("step 5: validating asynchronous soap response: response {}, definition {}", response, standardDefinition);
        return Mono.just(response).flatMap(r -> Mono.just(standardDefinition.soapResponseValidation())
                .flatMap(objectISoapResponseValidation -> {
                    final SoapValidationResult validation = objectISoapResponseValidation.validateResponse(response);
                    if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(validation.getValidateResult())) {
                        return Mono.error(() -> new SoapProcessException("Validation response failed"));
                    }
                    log.debug("step 5: valid passed asynchronous soap response: response {}, definition {}", response, standardDefinition);
                    return Mono.just(response);
                }));
    }

    private <T, R> ResponseProvider<R> buildResponse(final R response, final RequestProvider<T, R> request) {
        log.debug("step 6: builder soap response: response {}, request {}", response, request);
        return ResponseProvider.<R>builder()
                .response(response)
                .definition(request.getDefinition())
                .build();
    }


    private <T, R> Mono<ResponseProvider<R>> doOnBuildResponse(R response, RequestProvider<T, R> request) {
        log.debug("step 6: builder asynchronous soap response: response {}, request {}", response, request);
        ResponseProvider<R> responseProvider = ResponseProvider.<R>builder()
                .definition(request.getDefinition())
                .response(response)
                .build();
        return Mono.just(responseProvider);
    }

}
