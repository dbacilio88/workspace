package com.bacsystem.lib.providers.validations;

import com.bacsystem.lib.components.enums.ValidateResult;
import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapStandardDefinition;
import com.bacsystem.lib.dto.SoapValidationResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * <b>ISoapStandardDefinitionValidation</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapStandardDefinitionValidation} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz funcional para la validación de definiciones estándar de SOAP. Extiende la interfaz Function para validar un objeto {@link ISoapStandardDefinition} y devolver un resultado de validación.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@FunctionalInterface
public interface ISoapStandardDefinitionValidation extends Function<ISoapStandardDefinition, SoapValidationResult> {
    Logger log = LogManager.getLogger(ISoapStandardDefinitionValidation.class);

    /**
     * Método estático para obtener una instancia de validación de definiciones estándar.
     *
     * @return Una implementación de {@link ISoapStandardDefinitionValidation} que valida un {@link ISoapStandardDefinition}.
     */
    static ISoapStandardDefinitionValidation validation() {
        return definition -> {
            final SoapValidationResult result = SoapValidationResult.builder().validateResult(ValidateResult.PROCESS_VALIDATION_SUCCESS).build();
            if (Boolean.TRUE.equals(isInvalid(definition))) {
                String message = "error in definition standard is null";
                result.setValidateResult(ValidateResult.PROCESS_VALIDATION_ERROR);
                result.setErrors(List.of(message));
                log.error(message);
            }
            return result;
        };
    }

    /**
     * Combina esta validación con otra validación, realizando ambas en secuencia.
     *
     * @param other La otra validación a combinar.
     * @return Una nueva validación que ejecuta ambas.
     */
    default ISoapStandardDefinitionValidation and(ISoapStandardDefinitionValidation other) {
        return definition -> {
            final SoapValidationResult result = this.apply(definition);
            return ValidateResult.PROCESS_VALIDATION_SUCCESS.equals(result.getValidateResult()) ? other.apply(definition) : result;
        };
    }

    /**
     * Verifica si la definición proporcionada es inválida.
     *
     * @param definition El objeto ISoapStandardDefinition a validar.
     * @return true si la definición es nula o si sus validaciones son nulas, false de lo contrario.
     */
    static boolean isInvalid(final ISoapStandardDefinition definition) {
        return Objects.isNull(definition) ||
                Objects.isNull(definition.soapRequestValidation()) ||
                Objects.isNull(definition.soapResponseValidation());
    }
}
