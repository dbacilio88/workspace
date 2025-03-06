package com.bacsystem.lib.components.factories.abstracts.request;

import com.bacsystem.lib.dto.SoapParameter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * <b>SoapRequest</b>
 * <p>
 * This class specifies the requirements for the {@link SoapRequest} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Clase que representa una solicitud SOAP.</p>
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
public class SoapRequest<T> implements Serializable {

    private static final long serialVersionUID = -6026306123347839151L;
    /**
     * El objeto de solicitud que se enviará en la solicitud SOAP.
     */
    private T request;

    /**
     * Parámetros adicionales relacionados con la solicitud SOAP.
     */
    private SoapParameter parameter;
}
