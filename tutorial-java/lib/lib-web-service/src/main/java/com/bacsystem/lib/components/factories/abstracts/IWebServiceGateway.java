package com.bacsystem.lib.components.factories.abstracts;

/**
 * <b>IWebServiceGateway</b>
 * <p>
 * This class specifies the requirements for the {@link IWebServiceGateway} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para un gateway de servicios web. Proporciona un método para ejecutar solicitudes a servicios web.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface IWebServiceGateway {

    /**
     * Ejecuta una solicitud a un servicio web.
     *
     * @param request El objeto de solicitud que se enviará al servicio web.
     * @param actions Acciones adicionales que pueden influir en la ejecución de la solicitud.
     * @return Un objeto que representa la respuesta del servicio web.
     */
    Object execute(final Object request, final String actions);
}
