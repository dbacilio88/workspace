package com.bacsystem.landing.microservice.router.handlers;

import com.bacsystem.landing.microservice.components.base.response.ApplicationApiResponse;
import com.bacsystem.landing.microservice.components.base.response.ServerResponseBase;
import com.bacsystem.landing.microservice.services.contracts.IComponentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * <b>ComponentsHandler</b>
 * <p>
 * This class specifies the requirements for the {@link ComponentsHandler} component,
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

@Log4j2
@Component
public class ComponentsHandler extends ServerResponseBase {

    private final IComponentService componentService;

    public ComponentsHandler(ApplicationApiResponse applicationApiResponse,
                             IComponentService componentService) {
        super(applicationApiResponse);
        this.componentService = componentService;
    }

    public Mono<ServerResponse> doOnFindAllExecute(final ServerRequest request) {
        log.info("request {}",request);
        return this.componentService
                .doOnProcess()
                .flatMap(super::success);
    }
}
