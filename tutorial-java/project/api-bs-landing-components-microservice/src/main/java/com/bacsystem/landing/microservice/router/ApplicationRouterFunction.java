package com.bacsystem.landing.microservice.router;

import com.bacsystem.landing.microservice.router.handlers.ComponentsHandler;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 * <b>ApplicationRouterFunction</b>
 * <p>
 * This class specifies the requirements for the {@link ApplicationRouterFunction} component,
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
@Configuration
@AllArgsConstructor
public class ApplicationRouterFunction {
    private final ComponentsHandler componentsHandler;

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions
                .route(RequestPredicates
                        .GET("/components"), componentsHandler::doOnFindAllExecute);
    }
}
