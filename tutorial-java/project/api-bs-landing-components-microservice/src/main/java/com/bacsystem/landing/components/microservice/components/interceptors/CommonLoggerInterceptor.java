package com.bacsystem.landing.components.microservice.components.interceptors;

import com.bacsystem.landing.components.microservice.components.constants.ApplicationConstant;
import lombok.experimental.UtilityClass;
import org.springframework.http.server.PathContainer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Objects;
import java.util.function.Function;

/**
 * <b>CommonLoggerInterceptor</b>
 * <p>
 * This class specifies the requirements for the {@link CommonLoggerInterceptor} component,
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


@UtilityClass
public class CommonLoggerInterceptor {

    public static final Function<ServerWebExchange, Boolean> doOnValidateActuator = (
            exchange -> !Objects.isNull(exchange) && exchange.getRequest().getURI().getPath().contains(ApplicationConstant.MICROSERVICE_ACTUATOR_VALUE));

    public static final Function<ServerWebExchange, Boolean> doOnValidateHealthEndPoint = (exchange -> {
        if (Objects.isNull(exchange)) {
            return false;
        }

        var matches = PathContainer.parsePath(exchange.getRequest().getPath().pathWithinApplication().value());
        return new PathPatternParser().parse(ApplicationConstant.MICROSERVICE_ACTUATOR_PATH).matches(matches)
               || new PathPatternParser().parse(ApplicationConstant.MICROSERVICE_POD_INFO_PATH).matches(matches)
               || new PathPatternParser().parse(ApplicationConstant.MICROSERVICE_SWAGGER_UI_PATH).matches(matches)
               || new PathPatternParser().parse(ApplicationConstant.MICROSERVICE_SWAGGER_RESOURCES_PATH).matches(matches)
               || new PathPatternParser().parse(ApplicationConstant.MICROSERVICE_SWAGGER_V2_API_DOCS_PATH).matches(matches)
               || new PathPatternParser().parse(ApplicationConstant.MICROSERVICE_SWAGGER_V3_API_DOCS_PATH).matches(matches);

    });
}

