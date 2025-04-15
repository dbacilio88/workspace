package com.bacsystem.api.components.context;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.UnaryOperator;

/**
 * <b>TenantRoutingDataSource</b>
 * <p>
 * This class specifies the requirements for the {@link TenantRoutingDataSource} component,
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
public class TenantRoutingDataSource extends AbstractRoutingDataSource {


    private final Map<String, Mono<DataSource>> resolvedDataSources = new ConcurrentHashMap<>();
    UnaryOperator<String> functionMapper = a -> a;

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("Current Lookup key [{}]", TenantContext.getTenantId());
        return TenantContext.getTenantId();
    }

    @Override
    protected DataSource determineTargetDataSource() {
        log.info("Current Lookup key 2 [{}]", TenantContext.getTenantId());

        String tenantId = (String) determineCurrentLookupKey();
        log.info("Tenant id aqui: {}", tenantId);
        return Objects.requireNonNull(resolvedDataSources.computeIfAbsent(tenantId, key -> this.fetchAndCreateDataSourceFromConfigServer(tenantId)
                .doOnTerminate(() -> log.info("DataSource for tenant {} is ready", tenantId))).block());


    }

    private Mono<DataSource> fetchAndCreateDataSourceFromConfigServer(String tenantId) {
        return WebClient.create("http://config-server:8888")
                .get()
                .uri("/{tenantId}/default", tenantId)
                .retrieve()
                .bodyToMono(Map.class)
                .map(this::mapToDataSource)
                .onErrorMap(ex -> new RuntimeException("Could not fetch config for tenant " + tenantId, ex));
    }

    private DataSource mapToDataSource(Map<String, Object> config) {
        String jdbcUrl = (String) config.get("jdbcUrl");
        String username = (String) config.get("username");
        String password = (String) config.get("password");
        String driver = (String) config.get("driver");

        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .driverClassName(driver)
                .build();
    }
}
