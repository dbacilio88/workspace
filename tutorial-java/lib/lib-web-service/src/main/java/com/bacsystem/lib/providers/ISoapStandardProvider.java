package com.bacsystem.lib.providers;

import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapStandardDefinition;
import com.bacsystem.lib.providers.request.RequestProvider;
import com.bacsystem.lib.providers.response.ResponseProvider;
import reactor.core.publisher.Mono;

/**
 * <b>ISoapStandardProvider</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapStandardProvider} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para proporcionar servicios estándar de SOAP. Esta interfaz define métodos para realizar llamadas a servicios utilizando un proveedor de solicitudes y una definición estándar.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


public interface ISoapStandardProvider {

    /**
     * Llama a un servicio utilizando un proveedor de solicitudes y una definición estándar.
     *
     * @param request            El proveedor de solicitudes que contiene los datos necesarios para la llamada.
     * @param standardDefinition La definición estándar que especifica cómo debe manejarse la solicitud.
     * @param <T>                El tipo de la solicitud.
     * @param <R>                El tipo de la respuesta.
     * @return Un objeto {@link ResponseProvider} que contiene la respuesta del servicio.
     */
    <T, R> ResponseProvider<R> callService(RequestProvider<T, R> request, ISoapStandardDefinition standardDefinition);

    /**
     * Realiza una llamada a un servicio de forma asíncrona utilizando un proveedor de solicitudes y una definición estándar.
     *
     * @param request            El proveedor de solicitudes que contiene los datos necesarios para la llamada.
     * @param standardDefinition La definición estándar que especifica cómo debe manejarse la solicitud.
     * @param <T>                El tipo de la solicitud.
     * @param <R>                El tipo de la respuesta.
     * @return Un Mono que emite un objeto {@link ResponseProvider} que contiene la respuesta del servicio.
     */
    <T, R> Mono<ResponseProvider<R>> doOnCallService(RequestProvider<T, R> request, ISoapStandardDefinition standardDefinition);
}

