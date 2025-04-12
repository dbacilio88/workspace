package com.bacsystem.api.components.context;

import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

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

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        log.trace("Current Lookup key [{}]", TenantContext.getTenantId());
        return TenantContext.getTenantId();
    }
}
