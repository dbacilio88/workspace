package com.bacsystem.landing.microservice.components.base;

import com.bacsystem.landing.microservice.components.properties.MicroserviceProperties;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;

/**
 * <b>ApplicationBase</b>
 * <p>
 * This class specifies the requirements for the {@link ApplicationBase} component,
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
public abstract class ApplicationBase implements ApplicationListener<ContextRefreshedEvent> {

    private final MicroserviceProperties microserviceProperties;

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        log.info("************************ MICROSERVICE APP ADMIN CONSOLE ************************************");
        log.info("Application Name: {}", this.microserviceProperties.getName());
        log.info("Application Version: {}", this.microserviceProperties.getVersion());
        log.info("Application Port: {}", this.microserviceProperties.getPort());
        log.info("Application Path: {}", this.microserviceProperties.getPath());
        log.info("************************ MICROSERVICE APP ADMIN CONSOLE ************************************");
    }
}
