package com.bacsystem.landing.components.microservice.components.base.response.factory;

import reactor.core.publisher.Mono;

/**
 * <b>IResponseFactory</b>
 * <p>
 * This class specifies the requirements for the {@link IResponseFactory} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the api-bs-landing-components-microservice.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 4/18/2025
 */

public interface IResponseFactory {
    Mono<ResponseBuilder> service(String type);
}
