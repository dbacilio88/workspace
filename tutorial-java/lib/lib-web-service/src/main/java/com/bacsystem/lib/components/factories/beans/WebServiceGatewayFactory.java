package com.bacsystem.lib.components.factories.beans;

import com.bacsystem.lib.components.base.SoapBase;
import com.bacsystem.lib.components.factories.abstracts.IWebServiceGateway;
import com.bacsystem.lib.components.factories.abstracts.WebServiceGateway;
import com.bacsystem.lib.components.helpers.SoapGatewayHelper;
import com.bacsystem.lib.dto.SoapParameter;
import lombok.extern.log4j.Log4j2;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * <b>WebServiceGatewayFactory</b>
 * <p>
 * This class specifies the requirements for the {@link WebServiceGatewayFactory} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
@Component
public class WebServiceGatewayFactory extends SoapBase implements IWebServiceGatewayFactory {

    public WebServiceGatewayFactory() {
        super(WebServiceGatewayFactory.class.getSimpleName());
    }

    @Override
    public IWebServiceGateway factory(final SoapParameter parameter) {
        //TODO implement ssl
        WebServiceGateway gateway = new WebServiceGateway();
        // Construir el marshaller usando la ruta WSDL proporcionada
        final Jaxb2Marshaller marshaller = SoapGatewayHelper.buildMarshaller(parameter.getServiceGeneratorWsdlPath());

        // Configurar el gateway para usar SSL si se indica en los parámetros
        if (Boolean.TRUE.equals(parameter.isSsl())) {
            gateway.setWebServiceTemplate(new WebServiceTemplate(marshaller));
        }
        // Configurar la URI y los marshaller del gateway
        gateway.setDefaultUri(parameter.getServiceUri());
        gateway.setMarshaller(marshaller);
        gateway.setUnmarshaller(marshaller);
        return gateway;
    }
}
