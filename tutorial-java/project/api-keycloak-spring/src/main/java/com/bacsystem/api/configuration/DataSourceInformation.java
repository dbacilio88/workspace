package com.bacsystem.api.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>DataSourceInformation</b>
 * <p>
 * This class specifies the requirements for the {@link DataSourceInformation} component,
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


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceInformation {
    private String name;
    private String url;
    private String driverClassName;
    private String userName;
    private String password;
}
