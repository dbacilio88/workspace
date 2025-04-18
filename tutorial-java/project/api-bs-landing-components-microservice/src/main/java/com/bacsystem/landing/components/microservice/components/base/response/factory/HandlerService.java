package com.bacsystem.landing.components.microservice.components.base.response.factory;

import com.bacsystem.landing.components.microservice.components.base.response.ResponseBase;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * <b>ApplicationResponse</b>
 * <p>
 * This class specifies the requirements for the {@link HandlerService} component,
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
@Component(value = "handlerService")
public class HandlerService extends ResponseBuilder {
    @Override
    @SuppressWarnings("unchecked")
    public <T> Mono<T> builder(ResponseBase response, int code, MediaType mediaType) {
        response.setCode(code);
        response.setDateTime(new Date());
        response.setMessage(response.getMessage());
        response.setErrors(response.getErrors());
        return (Mono<T>) Mono.just(ResponseEntity.status(code)
                .contentType(mediaType)
                .body(response));

    }

}
