package com.bacsystem.landing.microservice.components.base.response.factory;

import com.bacsystem.landing.microservice.components.enums.ResponseCode;
import com.bacsystem.landing.microservice.components.exceptions.ApplicationException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Locale;

/**
 * <b>ResponseFactory</b>
 * <p>
 * This class specifies the requirements for the {@link ResponseFactory} component,
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
@AllArgsConstructor
public class ResponseFactory implements IResponseFactory {

    private final BeanFactory beanFactory;

    @Override
    public Mono<ResponseBuilder> service(String type) {
        return Mono.fromCallable(() -> beanFactory.getBean(type, ResponseBuilder.class))
                .doOnSuccess(builder -> log.debug("create bean {} success", type))
                .doOnError(throwable -> log.error("error build {}", throwable.getMessage(), throwable))
                .onErrorResume(BeansException.class, throwable ->
                        Mono.error(new ApplicationException(String.format("Response type [%s] not found", type), ResponseCode.NOT_FOUND)));
    }

    public static String makeStringToLowerCase(final String type) {
        return type.toLowerCase(Locale.ENGLISH);
    }
}
