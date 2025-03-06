package com.bacsystem.lib.components.factories.abstracts;

import lombok.extern.log4j.Log4j2;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * <b>WebServiceGateway</b>
 * <p>
 * This class specifies the requirements for the {@link WebServiceGateway} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Implementación del gateway para servicios web. Esta clase extiende WebServiceGatewaySupport e implementa IWebServiceGateway.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
public class WebServiceGateway extends WebServiceGatewaySupport implements IWebServiceGateway {

    public WebServiceGateway() {
        log.debug("load {} successfully", WebServiceGateway.class.getSimpleName());
    }

    @Override
    public Object execute(Object request, String actions) {
        log.debug("execute request to soap service: {}, with actions: {}", request, actions);
        // Envía la solicitud y recibe la respuesta utilizando el WebServiceTemplate
        final Object sendAndReceive = getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(actions));
        log.debug("receive response from soap service: {}, with actions: {}", sendAndReceive, actions);
        return sendAndReceive;
    }
}
