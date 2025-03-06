package com.bacsystem.lib.components.validations;

import com.bacsystem.lib.components.enums.ValidateResult;
import com.bacsystem.lib.dto.SoapParameter;
import com.bacsystem.lib.dto.SoapValidationResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * <b>ISoapParameterValidation</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapParameterValidation} component,
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


@FunctionalInterface
public interface ISoapParameterValidation extends Function<SoapParameter, SoapValidationResult> {
    Logger log = LogManager.getLogger(ISoapParameterValidation.class);

    /**
     * Método estático para obtener una instancia de validación de parámetros.
     *
     * @return Una implementación de {@link ISoapParameterValidation} que valida un {@link SoapParameter}.
     */
    static ISoapParameterValidation validation() {
        return soapParameter -> {
            final SoapValidationResult result = SoapValidationResult.builder().validateResult(ValidateResult.PROCESS_VALIDATION_SUCCESS).build();
            if (Boolean.TRUE.equals(isInvalid(soapParameter))) {
                String message = "error in parameter is null";
                result.setValidateResult(ValidateResult.PROCESS_VALIDATION_ERROR);
                result.setErrors(List.of(message));
                log.error(message);
            }
            return result;
        };
    }

    /**
     * Verifica si el {@link SoapParameter} proporcionado es inválido (nulo).
     *
     * @param soapParameter El objeto {@link SoapParameter} a validar.
     * @return true si el parámetro es nulo, false de lo contrario.
     */
    static boolean isInvalid(SoapParameter soapParameter) {
        return Objects.isNull(soapParameter);
    }
}
