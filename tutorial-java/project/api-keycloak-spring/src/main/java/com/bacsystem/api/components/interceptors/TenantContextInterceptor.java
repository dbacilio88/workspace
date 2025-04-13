package com.bacsystem.api.components.interceptors;

import com.bacsystem.api.components.context.TenantContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * <b>TenantContextInterceptor</b>
 * <p>
 * This class specifies the requirements for the {@link TenantContextInterceptor} component,
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
@Log4j2
@Component
public class TenantContextInterceptor implements WebFilter {

    public static final String TENANT_HEADER = "X-Tenant-ID";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        var tenantId = exchange.getRequest().getHeaders().getFirst(TENANT_HEADER);
        log.info("Tenant id: {}", tenantId);
        TenantContext.setTenantId(tenantId);
        return chain.filter(exchange)
                .doOnTerminate(TenantContext::clearTenantId);
    }
}
