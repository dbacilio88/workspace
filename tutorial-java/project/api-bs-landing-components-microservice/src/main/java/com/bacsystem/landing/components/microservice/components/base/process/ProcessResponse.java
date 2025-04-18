package com.bacsystem.landing.components.microservice.components.base.process;

import com.bacsystem.landing.components.microservice.components.base.enums.ProcessResult;
import com.bacsystem.landing.components.microservice.components.base.enums.ResponseCode;
import com.bacsystem.landing.components.microservice.components.base.response.ResponseBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * <b>ProcessResponse</b>
 * <p>
 * This class specifies the requirements for the {@link ProcessResponse} component,
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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProcessResponse {

    private ResponseCode responseCode;
    private ResponseBase response;
    private boolean isSuccess;
    private boolean isEmpty;
    private ProcessResult result;

    public static ProcessResponse success(@NonNull final ResponseBase response) {
        return build(response, ResponseCode.SUCCESS, ProcessResult.SUCCESS, true, false);
    }

    public static ProcessResponse empty(@NonNull final ResponseBase response) {
        return build(response, ResponseCode.SUCCESS, ProcessResult.SUCCESS, true, true);
    }

    public static ProcessResponse failure(@NonNull final ResponseBase response, @NonNull final ResponseCode responseCode) {
        return build(response, responseCode, ProcessResult.FAILURE, false, false);
    }

    public static ProcessResponse build(final ResponseBase response,
                                        final ResponseCode responseCode,
                                        final ProcessResult result,
                                        final boolean isSuccess,
                                        final boolean isEmpty) {
        return ProcessResponse.builder()
                .responseCode(responseCode)
                .response(response)
                .isSuccess(isSuccess)
                .isEmpty(isEmpty)
                .result(result)
                .build();
    }


    public boolean isFailure() {
        return !this.isSuccess;
    }

    public boolean exists() {
        return !Objects.isNull(this.response);
    }
}
