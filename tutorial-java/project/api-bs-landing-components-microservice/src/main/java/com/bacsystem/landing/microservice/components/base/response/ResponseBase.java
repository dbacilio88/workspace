package com.bacsystem.landing.microservice.components.base.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <b>ResponseBase</b>
 * <p>
 * This class specifies the requirements for the {@link ResponseBase} component,
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
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBase implements Serializable {
    @Serial
    private static final long serialVersionUID = -2662958105746237146L;
    @JsonProperty(value = "code")
    private int code;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "dateTime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date dateTime;

    @JsonProperty(value = "errors")
    private List<String> errors;

    public void setDateTime(Date dateTime) {
        this.dateTime = Optional
                .ofNullable(dateTime)
                .map(Date::getTime)
                .map(Date::new)
                .orElse(null);
    }

    public Date getDateTime() {
        return Optional
                .ofNullable(this.dateTime)
                .map(Date::getTime)
                .map(Date::new)
                .orElse(null);
    }
}
