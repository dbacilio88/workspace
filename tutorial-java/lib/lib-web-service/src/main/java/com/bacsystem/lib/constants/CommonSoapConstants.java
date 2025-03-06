package com.bacsystem.lib.constants;

import lombok.experimental.UtilityClass;

/**
 * <b>CommonSoapConstants</b>
 * <p>
 * This class specifies the requirements for the {@link CommonSoapConstants} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@UtilityClass
public class CommonSoapConstants {
    public static final String SOAP_SUPPRESS_WARNINGS_UNCHECKED = "unchecked";
    public static final String SOAP_SERVICE_IDENTIFICATION = "SOAP_SERVICE";
    public static final String SOAP_CUSTOM_PROVIDER_IDENTIFICATION = "SOAP_CUSTOM_PROVIDER";
    public static final String SOAP_STANDARD_PROVIDER_IDENTIFICATION = "SOAP_STANDARD_PROVIDER";
    public static final String SOAP_COMMON_SUCCESS_DO_ON_PROCESS_FORMAT = "process {} successfully completed, response: {}";
    public static final String SOAP_COMMON_ERROR_DO_ON_PROCESS_FORMAT = "error in process {}, error: {}";
}
