package com.bacsystem.landing.microservice.services.contracts;

import com.bacsystem.landing.microservice.components.base.process.ProcessResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

/**
 * <b>IComponentService</b>
 * <p>
 * This class specifies the requirements for the {@link IComponentService} component,
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

public interface IComponentService {
    Mono<ProcessResponse> doOnProcess(ServerRequest  request);
}
