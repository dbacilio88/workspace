package com.bacsystem.lib.components.factories.beans;


import com.bacsystem.lib.components.factories.abstracts.IWebServiceGateway;
import com.bacsystem.lib.dto.SoapParameter;

/**
 * <b>IWebServiceGatewayFactory</b>
 * <p>
 * This class specifies the requirements for the {@link IWebServiceGatewayFactory} component,
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

public interface IWebServiceGatewayFactory {

    /**
     * Crea una instancia de {@link IWebServiceGateway} basada en los parámetros SOAP proporcionados.
     *
     * @param parameter El parámetro que contiene la información necesaria para crear el gateway.
     * @return Una instancia de {@link IWebServiceGateway} .
     * @throws IllegalArgumentException Si el parámetro es nulo.
     */
    IWebServiceGateway factory(final SoapParameter parameter);
}
