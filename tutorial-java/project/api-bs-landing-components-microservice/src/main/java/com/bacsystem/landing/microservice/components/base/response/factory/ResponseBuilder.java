package com.bacsystem.landing.microservice.components.base.response.factory;

import com.bacsystem.landing.microservice.components.base.response.ResponseBase;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

/**
 * <b>ApplicationResponse</b>
 * <p>
 * This class specifies the requirements for the {@link ResponseBuilder} component,
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
public abstract class ResponseBuilder {

    public abstract <T> Mono<T> builder(final ResponseBase response, final int code, MediaType mediaType);
}
