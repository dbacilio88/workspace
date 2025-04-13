package com.bacsystem.api;

import com.bacsystem.api.components.context.TenantContext;
import com.bacsystem.api.configuration.ApplicationConfig;
import com.bacsystem.api.configuration.DataSourceInformation;
import com.bacsystem.api.configuration.DynamicDataSourceService;
import io.micrometer.context.ContextRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.config.ContextLifecycleScheduledTaskRegistrar;
import reactor.core.publisher.Hooks;

/**
 * <b>Application</b>
 * <p>
 * This class specifies the requirements for the {@link Application} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the api-keycloak-spring.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 3/5/2025
 */

@Log4j2
@AllArgsConstructor
@SpringBootApplication
public class Application implements ApplicationRunner {

    private final DynamicDataSourceService dynamicDataSourceService;
    private final ApplicationConfig applicationConfig;

    public static void main(String[] args) {
        enablePropagationContext();
        SpringApplication.run(Application.class, args);
    }

    public static void enablePropagationContext() {
        log.info("Propagation context enabled");
        Hooks.enableAutomaticContextPropagation();
        ContextRegistry.getInstance().registerThreadLocalAccessor(
                "DatasourseId", TenantContext::getTenantId,
                TenantContext::setTenantId, () -> {
                });
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (this.applicationConfig.getConfigurations()
                .stream()
                .noneMatch(dataSourceInformation ->
                        dataSourceInformation.getName().equals("default-h2"))) {
            log.warn("Tenant id [{}] not found. Proceed to find configuration", "default-h2");


            log.error("Tenant id [{}] not found.", "default-h2");

            var registeredDataSource = this.dynamicDataSourceService.registerDataSource(DataSourceInformation.builder()
                    .name("default-h2")
                    .url("jdbc:h2:mem:db")
                    .driverClassName("org.h2.Driver")
                    .password("")
                    .userName("sa")
                    .build());
            if (Boolean.FALSE.equals(registeredDataSource)) {
                log.error("Tenant id [{}] has invalid configuration.", false);
            }

            TenantContext.setTenantId("data1");
        }

    }
}
