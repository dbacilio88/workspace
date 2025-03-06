package com.bacsystem.lib.dto;

import com.bacsystem.lib.components.enums.ValidateResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * <b>SoapValidationResult</b>
 * <p>
 * This class specifies the requirements for the {@link SoapValidationResult} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Clase que representa el resultado de la validación de una solicitud SOAP.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoapValidationResult implements Serializable {

    private static final long serialVersionUID = -3353478897239419884L;

    /**
     * Resultado de la validación.
     */
    private ValidateResult validateResult;

    /**
     * Lista de errores encontrados durante la validación.
     */
    private List<String> errors;
}
