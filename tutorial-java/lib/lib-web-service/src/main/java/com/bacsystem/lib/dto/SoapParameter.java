package com.bacsystem.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * <b>SoapParameter</b>
 * <p>
 * This class specifies the requirements for the {@link SoapParameter} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Clase que representa los parámetros necesarios para una solicitud SOAP.</p>
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
public class SoapParameter implements Serializable {

    private static final long serialVersionUID = 6843717055778958903L;
    /**
     * Descripción del servicio SOAP.
     */
    private String serviceDescription;
    /**
     * Acción SOAP del servicio.
     */
    private String serviceSoapAction;
    /**
     * URI del servicio SOAP.
     */
    private String serviceUri;
    /**
     * Ruta del WSDL del generador de servicios.
     */
    private String serviceGeneratorWsdlPath;

    /**
     * Indica si se debe utilizar SSL para la conexión.
     */
    private boolean isSsl;
}
