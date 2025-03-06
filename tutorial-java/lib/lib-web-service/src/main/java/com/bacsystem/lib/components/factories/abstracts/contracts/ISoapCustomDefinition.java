package com.bacsystem.lib.components.factories.abstracts.contracts;

import com.bacsystem.lib.components.factories.abstracts.mappers.ISoapRequestMapper;
import com.bacsystem.lib.components.factories.abstracts.mappers.ISoapResponseMapper;
import com.bacsystem.lib.components.factories.abstracts.request.SoapRequest;
import com.bacsystem.lib.components.factories.abstracts.validations.ISoapRequestValidation;
import com.bacsystem.lib.components.factories.abstracts.validations.ISoapResponseValidation;

/**
 * <b>ISoapCustomDefinition</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapCustomDefinition} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Proporciona métodos para mapear solicitudes y respuestas SOAP, así como para la validación de las mismas.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


public interface ISoapCustomDefinition {

    /**
     * Crea un mapper de solicitud SOAP.
     *
     * @param <SQ> Tipo de entrada para la solicitud.
     * @param <RQ> Tipo de salida para la solicitud.
     * @return Una instancia de {@link ISoapRequestMapper}.
     */
    <SQ, RQ> ISoapRequestMapper<SQ, RQ> toSoapMapperRequest();

    /**
     * Crea un mapper de respuesta SOAP.
     *
     * @param <SR> Tipo de entrada para la respuesta.
     * @param <RR> Tipo de salida para la respuesta.
     * @return Una instancia de {@link ISoapResponseMapper}.
     */
    <SR, RR> ISoapResponseMapper<SR, RR> toSoapMapperResponse();

    /**
     * Crea una instancia de validación para la solicitud SOAP.
     *
     * @param <SQ> Tipo de entrada para la validación de la solicitud.
     * @return Una instancia de {@link ISoapRequestValidation}.
     */
    <SQ> ISoapRequestValidation<SQ> soapRequestValidation();

    /**
     * Crea una instancia de validación para la respuesta SOAP.
     *
     * @param <SR> Tipo de entrada para la validación de la respuesta.
     * @return Una instancia de {@link ISoapResponseValidation}.
     */
    <SR> ISoapResponseValidation<SR> soapResponseValidation();

    /**
     * Crea un objeto de solicitud SOAP a partir del objeto de solicitud proporcionado.
     *
     * @param request El objeto de solicitud a ser convertido.
     * @param <SQ>    Tipo de la solicitud.
     * @return Un objeto de tipo {@link SoapRequest}.
     */
    <SQ> SoapRequest<SQ> soapRequest(SQ request);
}