package com.bacsystem.landing.microservice.components.decorators;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import reactor.core.publisher.Flux;

/**
 * <b>HttpRequestDecorator</b>
 * <p>
 * This class specifies the requirements for the {@link HttpRequest} component,
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
public class HttpRequest extends ServerHttpRequestDecorator {
    public HttpRequest(ServerHttpRequest delegate) {
        super(delegate);
    }

    @NonNull
    @Override
    public Flux<DataBuffer> getBody() {
        log.debug("Request from {} ", super.getPath());
        return super.getBody();
    }
}
