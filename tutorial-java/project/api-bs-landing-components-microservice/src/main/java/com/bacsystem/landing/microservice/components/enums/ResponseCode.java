package com.bacsystem.landing.microservice.components.enums;

import lombok.Getter;

/**
 * <b>ResponseCode</b>
 * <p>
 * This class specifies the requirements for the {@link ResponseCode} component,
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
@Getter
public enum ResponseCode {
    SUCCESS(200),
    NOT_FOUND(404);

    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
