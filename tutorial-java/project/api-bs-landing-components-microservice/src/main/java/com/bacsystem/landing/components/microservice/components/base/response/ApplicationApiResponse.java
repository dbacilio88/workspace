package com.bacsystem.landing.components.microservice.components.base.response;

import com.bacsystem.landing.components.microservice.components.base.response.factory.IResponseFactory;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * <b>ApplicationResponse</b>
 * <p>
 * This class specifies the requirements for the {@link ApplicationApiResponse} component,
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
@Validated
@Component
@AllArgsConstructor
public class ApplicationApiResponse {

    private final IResponseFactory responseFactory;

    public Mono<ServerResponse> success(final ResponseBase response, final int code) {
        return this.responseFactory.service("apiService")
                .flatMap(type -> type.builder(response, code, MediaType.APPLICATION_JSON));
    }

    public Mono<ServerResponse> failure(final ResponseBase response, final int code) {
        return this.responseFactory.service("apiService")
                .flatMap(type -> type.builder(response, code, MediaType.APPLICATION_JSON));
    }
}
