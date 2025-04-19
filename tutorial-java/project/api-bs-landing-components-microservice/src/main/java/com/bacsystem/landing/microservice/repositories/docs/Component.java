package com.bacsystem.landing.microservice.repositories.docs;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * <b>Component</b>
 * <p>
 * This class specifies the requirements for the {@link Component} component,
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "components")
public class Component {
    @Id
    private String id;
    @Field(name = "name")
    private String name;
}
