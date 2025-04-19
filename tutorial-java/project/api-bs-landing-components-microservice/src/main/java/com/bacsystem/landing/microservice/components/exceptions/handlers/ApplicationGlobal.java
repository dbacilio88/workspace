package com.bacsystem.landing.microservice.components.exceptions.handlers;

import com.bacsystem.landing.microservice.components.base.response.ApplicationHandlerResponse;
import com.bacsystem.landing.microservice.components.base.response.ResponseBase;
import com.bacsystem.landing.microservice.components.exceptions.ApplicationException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

/**
 * <b>ApplicationGlobalHandler</b>
 * <p>
 * This class specifies the requirements for the {@link ApplicationGlobal} component,
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
@RestControllerAdvice
@AllArgsConstructor
public class ApplicationGlobal {
    private final ApplicationHandlerResponse applicationHandlerResponse;

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<ResponseEntity<Object>> handlerException(ResponseStatusException exception) {
        return applicationHandlerResponse.failure(
                ResponseBase.builder()
                        .code(exception.getStatusCode().value())
                        .message(exception.getMessage())
                        .build(), exception.getStatusCode().value());
    }

    @ExceptionHandler(ApplicationException.class)
    public Mono<ResponseEntity<Object>> handlerException(ApplicationException exception) {
        return applicationHandlerResponse.failure(
                ResponseBase.builder()
                        .code(exception.getResponseCode().getCode())
                        .message(exception.getMessage())
                        .build(), exception.getResponseCode().getCode()
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<Object>> constraintViolationException(ConstraintViolationException exception) {
        return applicationHandlerResponse.failure(
                ResponseBase.builder()
                        .code(400)
                        .errors(exception
                                .getConstraintViolations()
                                .stream()
                                .map(constraint -> String.format("Field %s: %s", constraint.getPropertyPath(), constraint.getMessage()))
                                .toList())
                        .message("Parameter invalid")
                        .build(), 400);
    }

}
