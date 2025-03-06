package com.bacsystem.lib.components.factories.abstracts.contracts;

import com.bacsystem.lib.components.factories.abstracts.request.SoapRequest;
import com.bacsystem.lib.components.factories.abstracts.validations.ISoapRequestValidation;
import com.bacsystem.lib.components.factories.abstracts.validations.ISoapResponseValidation;

/**
 * <b>ISoapStandardDefinition</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapStandardDefinition} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para la fábrica de definiciones estándar de SOAP.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


public interface ISoapStandardDefinition {

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
