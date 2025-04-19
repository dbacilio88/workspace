package com.bacsystem.landing.microservice.components.base.response.factory;

import com.bacsystem.landing.microservice.components.base.response.ResponseBase;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * <b>ApplicationResponse</b>
 * <p>
 * This class specifies the requirements for the {@link ApiService} component,
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
@Component(value = "apiService")
public class ApiService extends ResponseBuilder {

    @Override
    @SuppressWarnings("unchecked")
    public <T> Mono<T> builder(ResponseBase response, int code, MediaType mediaType) {
        response.setCode(code);
        response.setDateTime(new Date());
        response.setMessage(response.getMessage());
        response.setErrors(response.getErrors());
        return (Mono<T>) ServerResponse
                .status(code)
                .contentType(mediaType)
                .body(BodyInserters.fromValue(response));

    }
}
