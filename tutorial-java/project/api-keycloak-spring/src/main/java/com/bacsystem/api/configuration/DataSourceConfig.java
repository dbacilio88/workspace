package com.bacsystem.api.configuration;

import com.bacsystem.api.components.context.TenantRoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>DataSourceConfig</b>
 * <p>
 * This class specifies the requirements for the {@link DataSourceConfig} component,
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
@Configuration
@AllArgsConstructor
@EnableTransactionManagement
public class DataSourceConfig {

    private final ApplicationConfig applicationConfig;

    @Bean
    public DataSourceProperties getDataSourceProperties() {
        log.info("Get DataSourceProperties");
        return new DataSourceProperties();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        log.info("Creating JDBC Template");
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource getDataSource() {
        log.info("Creating DataSource");
        Map<Object, Object> dataSources = new HashMap<>();
        this.applicationConfig.getConfigurations()
                .forEach(configuration ->
                        dataSources.put(configuration.getName(), DataSourceBuilder
                                .create()
                                .type(HikariDataSource.class)
                                .driverClassName(configuration.getDriverClassName())
                                .url(configuration.getUrl())
                                .username(configuration.getUserName())
                                .password(configuration.getPassword())
                                .build()));
        log.info("Data sources loaded [{}]", dataSources.keySet());
        TenantRoutingDataSource routingDataSource = new TenantRoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(dataSources.get(this.applicationConfig
                .getConfigurations().getFirst().getName()));
        routingDataSource.setTargetDataSources(dataSources);
        return routingDataSource;
    }
}
