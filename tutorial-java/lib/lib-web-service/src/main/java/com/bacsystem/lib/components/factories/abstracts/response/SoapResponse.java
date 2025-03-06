package com.bacsystem.lib.components.factories.abstracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * <b>SoapResponse</b>
 * <p>
 * This class specifies the requirements for the {@link SoapResponse} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Clase que representa una respuesta SOAP.</p>
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
public class SoapResponse<R> implements Serializable {

    private static final long serialVersionUID = 8252407493505520297L;

    /**
     * El objeto de respuesta que se recibirá en la respuesta SOAP.
     */
    private R response;
}
