package com.bacsystem.api.configuration;

import com.bacsystem.api.components.interceptors.TenantContextInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * <b>WebMvcConfig</b>
 * <p>
 * This class specifies the requirements for the {@link WebMvcConfig} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the api-keycloak-spring.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 4/12/2025
 */
@EnableWebFlux
@Configuration
public class WebMvcConfig implements WebFluxConfigurer {

    private final TenantContextInterceptor tenantContextInterceptor;

    public WebMvcConfig(TenantContextInterceptor tenantContextInterceptor) {
        this.tenantContextInterceptor = tenantContextInterceptor;
    }

}
