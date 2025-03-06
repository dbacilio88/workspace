package com.bacsystem.lib.components.factories.abstracts.validations;


import com.bacsystem.lib.dto.SoapValidationResult;

/**
 * <b>ISoapResponseValidation</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapResponseValidation} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para la validación de respuestas SOAP.</p>
 * <p>
 *
 * @param <R> Tipo de datos de la respuesta que se va a validar.
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface ISoapResponseValidation<R> {

    /**
     * Válida una respuesta SOAP.
     *
     * @param response El objeto de respuesta que se va a validar.
     * @return Un objeto de tipo {@link SoapValidationResult} que representa el resultado de la validación.
     */
    SoapValidationResult validateResponse(R response);
}