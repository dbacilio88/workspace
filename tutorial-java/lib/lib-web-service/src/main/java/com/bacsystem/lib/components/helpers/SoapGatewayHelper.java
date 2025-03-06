package com.bacsystem.lib.components.helpers;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * <b>SoapGatewayHelper</b>
 * <p>
 * This class specifies the requirements for the {@link SoapGatewayHelper} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Clase de utilidad para ayudar en la configuración de gateways SOAP.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
@UtilityClass
public class SoapGatewayHelper {

    /**
     * Construye un marshaller basado en el contexto proporcionado.
     *
     * @param contextPath La ruta del contexto que se utilizará para el marshaller.
     * @return Una instancia de {@link Jaxb2Marshaller} configurada con el contexto especificado.
     */
    public static Jaxb2Marshaller buildMarshaller(final String contextPath) {
        log.debug("create context path by soap service: {}", contextPath);
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(contextPath);
        marshaller.setPackagesToScan(contextPath);
        return marshaller;
    }
}