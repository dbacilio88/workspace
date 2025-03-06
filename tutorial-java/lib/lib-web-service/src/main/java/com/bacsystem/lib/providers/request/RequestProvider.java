package com.bacsystem.lib.providers.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * <b>RequestProvider</b>
 * <p>
 * This class specifies the requirements for the {@link RequestProvider} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Clase que representa un proveedor de solicitudes y respuestas. Esta clase contiene la definición, la solicitud y la respuesta asociada.</p>
 * </p>
 *
 * @param <T> El tipo de la solicitud.
 * @param <R> El tipo de la respuesta.
 *            </p>
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
public class RequestProvider<T, R> implements Serializable {

    private static final long serialVersionUID = 4974680045290018744L;

    /**
     * Definición de la solicitud.
     */
    private String definition;

    /**
     * Objeto que representa la solicitud.
     */
    private T request;

    /**
     * Objeto que representa la respuesta.
     */
    private R response;

}
