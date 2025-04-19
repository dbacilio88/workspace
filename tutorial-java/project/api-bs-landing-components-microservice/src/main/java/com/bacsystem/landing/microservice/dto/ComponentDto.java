package com.bacsystem.landing.microservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * <b>ComponentDto</b>
 * <p>
 * This class specifies the requirements for the {@link ComponentDto} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the api-bs-landing-components-microservice.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 4/19/2025
 */


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComponentDto {
    private String id;
    private String name;
}
