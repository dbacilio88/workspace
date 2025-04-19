package com.bacsystem.landing.microservice.components.interceptors;

import com.bacsystem.landing.microservice.components.constants.ApplicationConstant;
import com.bacsystem.landing.microservice.components.decorators.HttpRequest;
import com.bacsystem.landing.microservice.components.decorators.HttpResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * <b>LoggerInterceptor</b>
 * <p>
 * This class specifies the requirements for the {@link LoggerInterceptor} component,
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
public class LoggerInterceptor implements WebFilter {

    @NonNull
    @Override
    public Mono<Void> filter(@NonNull ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        log.info("pre request {} ", exchange.getRequest());

        if (Boolean.TRUE.equals(CommonLoggerInterceptor.doOnValidateHealthEndPoint.apply(exchange))) {
            return chain.filter(exchange.mutate().build());
        }
        log.info("post request {} ", exchange.getRequest().getPath().contextPath());
        return chain.filter(
                        exchange.mutate()
                                .request(new HttpRequest(exchange.getRequest()))
                                .response(new HttpResponse(exchange.getResponse()))
                                .build()
                )
                .contextWrite(context -> context.put(ApplicationConstant.HEADER_KEY, exchange.getRequest()))
                .contextWrite(context -> context.put(ApplicationConstant.HEADER_REQUEST_ID, exchange.getRequest()))
                .contextWrite(context -> context.put(ApplicationConstant.HEADER_USER_ID, exchange.getRequest()))
                .contextWrite(context -> context.put(ApplicationConstant.HEADER_TENANT_ID, exchange.getRequest()));

    }
}
