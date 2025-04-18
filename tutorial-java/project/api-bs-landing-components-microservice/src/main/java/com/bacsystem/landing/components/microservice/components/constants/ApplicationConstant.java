package com.bacsystem.landing.components.microservice.components.constants;

import lombok.experimental.UtilityClass;

/**
 * <b>ApplicationConstant</b>
 * <p>
 * This class specifies the requirements for the {@link ApplicationConstant} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the api-bs-landing-components-microservice.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 4/18/2025
 */

@UtilityClass
public class ApplicationConstant {
    public static final String HEADER_REQUEST_ID = "X-Request-Id";
    public static final String HEADER_USER_ID = "X-User-Id";
    public static final String HEADER_TENANT_ID = "X-Tenant-Id";
    public static final String HEADER_EMPTY = "";
    public static final String HEADER_KEY = "request";
    public static final String MICROSERVICE_POD_INFO_PATH = "/podInfo";
    public static final String MICROSERVICE_ACTUATOR_PATH = "/actuator/**";
    public static final String MICROSERVICE_ACTUATOR_VALUE = "actuator";
    public static final String MICROSERVICE_SWAGGER_UI_PATH = "/swagger-ui/**";
    public static final String MICROSERVICE_SWAGGER_RESOURCES_PATH = "/swagger-resources/**";
    public static final String MICROSERVICE_SWAGGER_V2_API_DOCS_PATH = "/v2/api-docs";
    public static final String MICROSERVICE_SWAGGER_V3_API_DOCS_PATH = "/v3/api-docs";
    public static final String MICROSERVICE_HANDLER_NOT_LINK_PATH = "ERROR_HANDLER_LINK_NOT_DEFINED";

}
