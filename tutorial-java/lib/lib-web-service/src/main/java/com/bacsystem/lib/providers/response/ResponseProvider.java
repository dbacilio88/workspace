package com.bacsystem.lib.providers.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * <b>ResponseProvider</b>
 * <p>
 * This class specifies the requirements for the {@link ResponseProvider} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * <p>Clase que representa un proveedor de respuestas. Esta clase contiene la respuesta y la definición asociada.</p>
 *
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
public class ResponseProvider<R> implements Serializable {

    private static final long serialVersionUID = -5638849915080478381L;

    /**
     * Objeto que representa la respuesta.
     */
    private R response;
    /**
     * Definición de la respuesta.
     */
    private String definition;
}
