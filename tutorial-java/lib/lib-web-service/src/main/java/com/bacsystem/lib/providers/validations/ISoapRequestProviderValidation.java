package com.bacsystem.lib.providers.validations;

import com.bacsystem.lib.components.enums.ValidateResult;
import com.bacsystem.lib.dto.SoapValidationResult;
import com.bacsystem.lib.providers.request.RequestProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * <b>ISoapRequestProviderValidation</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapRequestProviderValidation} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Extiende la interfaz Function para validar un objeto {@link RequestProvider}  y devolver un resultado de validación.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@FunctionalInterface
public interface ISoapRequestProviderValidation extends Function<RequestProvider<?, ?>, SoapValidationResult> {
    Logger log = LogManager.getLogger(ISoapRequestProviderValidation.class);

    /**
     * Método estático para obtener una instancia de validación de proveedores de solicitudes.
     *
     * @return Una implementación de {@link ISoapRequestProviderValidation} que valida un {@link RequestProvider}.
     */
    static ISoapRequestProviderValidation validation() {
        return request -> {
            final SoapValidationResult result = SoapValidationResult.builder().validateResult(ValidateResult.PROCESS_VALIDATION_SUCCESS).build();
            if (Boolean.TRUE.equals(isInvalid(request))) {
                String message = "error in request is null";
                result.setValidateResult(ValidateResult.PROCESS_VALIDATION_ERROR);
                result.setErrors(List.of(message));
                log.error(message);
            }
            return result;
        };
    }

    /**
     * Verifica si el proveedor de solicitudes proporcionado es inválido.
     *
     * @param request El objeto {@link RequestProvider} a validar.
     * @return true si el proveedor de solicitudes es nulo, false de lo contrario.
     */
    static boolean isInvalid(final RequestProvider<?, ?> request) {
        return Objects.isNull(request);
    }
}

