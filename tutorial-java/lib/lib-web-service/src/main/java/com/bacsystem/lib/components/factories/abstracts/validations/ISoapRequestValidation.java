package com.bacsystem.lib.components.factories.abstracts.validations;


import com.bacsystem.lib.dto.SoapValidationResult;

/**
 * <b>ISoapRequestValidation</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapRequestValidation} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para la validación de solicitudes SOAP.</p>
 *
 * @param <T> Tipo de datos de la solicitud que se va a validar.
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface ISoapRequestValidation<T> {
    /**
     * Valida una solicitud SOAP.
     *
     * @param request El objeto de solicitud que se va a validar.
     * @return Un objeto de tipo {@link SoapValidationResult} que representa el resultado de la validación.
     */
    SoapValidationResult validateRequest(T request);
}
