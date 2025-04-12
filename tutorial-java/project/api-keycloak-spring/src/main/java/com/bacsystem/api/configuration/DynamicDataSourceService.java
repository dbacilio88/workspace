package com.bacsystem.api.configuration;

import com.bacsystem.api.components.constants.MultiTenantConstants;
import com.bacsystem.api.components.context.TenantRoutingDataSource;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>DynamicDataSourceService</b>
 * <p>
 * This class specifies the requirements for the {@link DynamicDataSourceService} component,
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
@Service
@AllArgsConstructor
public class DynamicDataSourceService {

    private final ApplicationConfig applicationConfig;
    private final DefaultListableBeanFactory beanFactory;

    public boolean registerDataSource(DataSourceInformation dataSourceInformation) {
        if (validateConnection(dataSourceInformation)) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(DriverManagerDataSource.class);
            builder.addPropertyValue(MultiTenantConstants.KEY_DS_URL, dataSourceInformation.getUrl());
            builder.addPropertyValue(MultiTenantConstants.KEY_DS_DRIVER_CLASS_NAME, dataSourceInformation.getDriverClassName());
            builder.addPropertyValue(MultiTenantConstants.KEY_DS_USERNAME, dataSourceInformation.getUserName());
            builder.addPropertyValue(MultiTenantConstants.KEY_DS_PASSWORD, dataSourceInformation.getPassword());

            BeanDefinitionHolder holder = new BeanDefinitionHolder(builder.getBeanDefinition(), dataSourceInformation.getName());
            BeanDefinitionReaderUtils.registerBeanDefinition(holder, beanFactory);
            addNewDataSource(dataSourceInformation);
            registerNewDataSourceOnActiveRouting();
            return true;
        }
        return false;
    }

    private void registerNewDataSourceOnActiveRouting() {
        Map<Object, Object> targetDataSource = new HashMap<>();
        this.applicationConfig.getConfigurations().forEach(configuration ->
                targetDataSource.put(configuration.getName(), DataSourceBuilder
                        .create().build()));
        TenantRoutingDataSource routingDataSource = this.beanFactory.getBean(TenantRoutingDataSource.class);
        routingDataSource.setTargetDataSources(targetDataSource);
        routingDataSource.afterPropertiesSet();
        log.info("Registered new DataSource successfully");
    }

    private void addNewDataSource(DataSourceInformation dataSourceInformation) {
        this.applicationConfig.getConfigurations()
                .add(dataSourceInformation);
    }

    private boolean validateConnection(DataSourceInformation dataSourceInformation) {
        try (Connection connection = DriverManager.getConnection(
                dataSourceInformation.getUrl(),
                dataSourceInformation.getUserName(),
                dataSourceInformation.getPassword())) {
            log.info("Connection to [{}] has been established.", dataSourceInformation.getName());
            return connection.isValid(1000);
        } catch (SQLException e) {
            log.error("Connection to [{}] failed. [{}]", dataSourceInformation.getName(), e.getSQLState());
            return false;
        }
    }

}
