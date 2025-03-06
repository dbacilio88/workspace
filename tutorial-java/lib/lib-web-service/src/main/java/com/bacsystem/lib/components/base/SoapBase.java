package com.bacsystem.lib.components.base;

import lombok.extern.log4j.Log4j2;

/**
 * <b>SoapBase</b>
 * <p>
 * This class specifies the requirements for the {@link SoapBase} component,
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


@Log4j2
public class SoapBase {
    public SoapBase(String name) {
        log.debug("load {} successfully", name);
    }
}
