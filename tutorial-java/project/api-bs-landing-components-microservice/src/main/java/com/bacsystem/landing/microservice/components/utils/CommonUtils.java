package com.bacsystem.landing.microservice.components.utils;

import lombok.experimental.UtilityClass;

import java.util.Objects;

/**
 * <b>CommonUtils</b>
 * <p>
 * This class specifies the requirements for the {@link CommonUtils} component,
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
public class CommonUtils {

    private static final Long ID_ZERO_VALUE = 0L;

    public static boolean isValidateId(final Long id) {
        if (Objects.isNull(id) || ID_ZERO_VALUE.equals(id)) {
            return false;
        }

        return id > ID_ZERO_VALUE;
    }

}
