package com.bacsystem.lib.components.factories.services;


import com.bacsystem.lib.components.base.SoapBase;
import com.bacsystem.lib.components.enums.ValidateResult;
import com.bacsystem.lib.components.exceptions.SoapProcessException;
import com.bacsystem.lib.components.factories.abstracts.IWebServiceGateway;
import com.bacsystem.lib.components.factories.abstracts.request.SoapRequest;
import com.bacsystem.lib.components.factories.abstracts.response.SoapResponse;
import com.bacsystem.lib.components.factories.beans.IWebServiceGatewayFactory;
import com.bacsystem.lib.components.validations.ISoapParameterValidation;
import com.bacsystem.lib.dto.SoapValidationResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.bacsystem.lib.constants.CommonSoapConstants.SOAP_SERVICE_IDENTIFICATION;
import static com.bacsystem.lib.constants.CommonSoapConstants.SOAP_SUPPRESS_WARNINGS_UNCHECKED;

/**
 * <b>SoapService</b>
 * <p>
 * This class specifies the requirements for the {@link SoapService} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Implementación del servicio SOAP. Esta clase proporciona métodos para realizar llamadas a servicios SOAP.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
@Service(value = SOAP_SERVICE_IDENTIFICATION)
@SuppressWarnings(SOAP_SUPPRESS_WARNINGS_UNCHECKED)
public class SoapService extends SoapBase implements ISoapService {

    private final IWebServiceGatewayFactory gatewayFactory;

    public SoapService(final IWebServiceGatewayFactory gatewayFactory) {
        super(SoapService.class.getSimpleName());
        this.gatewayFactory = gatewayFactory;
    }

    @Override
    public <T, R> SoapResponse<R> call(SoapRequest<T> request) {
        final SoapResponse<R> response = new SoapResponse<>();
        IWebServiceGateway serviceGateway = getWebServiceGatewayFactory(request);
        final Object serviceResponse = serviceGateway.execute(request.getRequest(), request.getParameter().getServiceSoapAction());
        response.setResponse((R) serviceResponse);
        return response;
    }

    @Override
    public <T, R> Mono<SoapResponse<R>> doOnCall(SoapRequest<T> request) {
        // TODO
        return null;
    }


    /**
     * Obtiene la instancia de {@link IWebServiceGateway} basada en los parámetros de la solicitud.
     *
     * @param request El objeto {@link SoapRequest} que contiene los parámetros de la solicitud.
     * @param <T>     El tipo de datos de la solicitud.
     * @return Una instancia de {@link IWebServiceGateway}.
     */
    private <T> IWebServiceGateway getWebServiceGatewayFactory(SoapRequest<T> request) {
        SoapValidationResult result = ISoapParameterValidation.validation().apply(request.getParameter());
        if (ValidateResult.PROCESS_VALIDATION_ERROR.equals(result.getValidateResult())) {
            log.error(result.getValidateResult());
            throw new SoapProcessException("error parameter invalid");
        }
        return this.gatewayFactory.factory(request.getParameter());
    }

}
