package com.bacsystem.landing.components.microservice.components.base.response;

import com.bacsystem.landing.components.microservice.components.base.process.ProcessResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * <b>ServerResponseBase</b>
 * <p>
 * This class specifies the requirements for the {@link ServerResponseBase} component,
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
@AllArgsConstructor
public class ServerResponseBase {
    private final ApplicationApiResponse applicationApiResponse;

    public Mono<ServerResponse> success(final ProcessResponse processResponse) {
        return Mono.just(processResponse)
                .flatMap(process -> {
                    if (process.isFailure() && Objects.nonNull(process.getResponse())) {
                        log.info("response error {}, code [{}] ", process.getResponse(), process.getResponse().getCode());
                        return applicationApiResponse.failure(process.getResponse(), process.getResponseCode().getCode());
                    }
                    if (process.isEmpty()) {
                        log.info("response empty {}, code [{}] ", process.getResponse(), process.getResponse().getCode());
                        return applicationApiResponse.success(process.getResponse(), process.getResponseCode().getCode());
                    }
                    log.info("response success {}, code [{}] ", process.getResponse(), process.getResponse().getCode());
                    return applicationApiResponse.success(process.getResponse(), process.getResponseCode().getCode());
                })
                .doOnSuccess(serverResponse -> log.info("response success {}", serverResponse))
                .onErrorResume(throwable -> this.applicationApiResponse.failure(processResponse.getResponse(), 500));
    }
}
