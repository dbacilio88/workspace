package com.bacsystem.api.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <b>ApplicationConfig</b>
 * <p>
 * This class specifies the requirements for the {@link ApplicationConfig} component,
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

@Component
@Configuration
@ConfigurationProperties(prefix = "application")
@Data
public class ApplicationConfig {

    @Value("${application.entity-id}")
    private String entityId;

    private String  encryptionKey;

    private List<DataSourceInformation> configurations;

}
