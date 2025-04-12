package com.bacsystem.api.components.context;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * <b>TenantContext</b>
 * <p>
 * This class specifies the requirements for the {@link TenantContext} component,
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
@UtilityClass
public class TenantContext {

    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        log.info("Switching to tenantId: [{}]", tenantId);
        currentTenant.set(tenantId);
    }

    public static String getTenantId() {
        return currentTenant.get();
    }

    public static void clearTenantId() {
        currentTenant.remove();
    }
}
