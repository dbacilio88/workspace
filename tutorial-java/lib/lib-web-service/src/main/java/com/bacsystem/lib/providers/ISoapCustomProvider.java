package com.bacsystem.lib.providers;


import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapCustomDefinition;
import com.bacsystem.lib.providers.request.RequestProvider;
import com.bacsystem.lib.providers.response.ResponseProvider;

/**
 * <b>ISoapCustomProvider</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapCustomProvider} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Esta interfaz define un método para realizar una llamada a un servicio usando un proveedor de solicitudes y una definición personalizada.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface ISoapCustomProvider {

    /**
     * Llama a un servicio utilizando un proveedor de solicitudes y una definición personalizada.
     *
     * @param request          El proveedor de solicitudes que contiene los datos necesarios para la llamada.
     * @param customDefinition La definición personalizada que especifica cómo debe manejarse la solicitud.
     * @param <T>              El tipo de la solicitud.
     * @param <R>              El tipo de la respuesta.
     * @return Un objeto {@link ResponseProvider} que contiene la respuesta del servicio.
     */
    <T, R> ResponseProvider<R> callService(RequestProvider<T, R> request, ISoapCustomDefinition customDefinition);
}
