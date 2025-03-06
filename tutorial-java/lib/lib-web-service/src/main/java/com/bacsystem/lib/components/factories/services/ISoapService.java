package com.bacsystem.lib.components.factories.services;

import com.bacsystem.lib.components.factories.abstracts.request.SoapRequest;
import com.bacsystem.lib.components.factories.abstracts.response.SoapResponse;
import reactor.core.publisher.Mono;

/**
 * <b>ISoapService</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapService} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para un servicio SOAP. Proporciona un método para realizar llamadas a servicios SOAP.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface ISoapService {

    /**
     * Realiza una llamada a un servicio SOAP con la solicitud proporcionada.
     *
     * @param request El objeto {@link SoapRequest} que contiene los datos de la solicitud.
     * @param <T>     El tipo de datos de la respuesta.
     * @param <R>     El tipo de datos de la solicitud.
     * @return Un objeto {@link SoapResponse} que contiene los datos de la respuesta del servicio SOAP.
     */
    <T, R> SoapResponse<R> call(SoapRequest<T> request);

    /**
     * Realiza una llamada a un servicio SOAP con la solicitud proporcionada.
     *
     * @param request El objeto {@link SoapRequest} que contiene los datos de la solicitud.
     * @param <T>     El tipo de datos de la respuesta.
     * @param <R>     El tipo de datos de la solicitud.
     * @return Un objeto {@link SoapResponse} que contiene los datos de la respuesta del servicio SOAP.
     */
    <T, R> Mono<SoapResponse<R>> doOnCall(SoapRequest<T> request);
}