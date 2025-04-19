package com.bacsystem.landing.microservice.services.mapper;

import com.bacsystem.landing.microservice.dto.ComponentDto;
import com.bacsystem.landing.microservice.repositories.docs.Component;
import org.mapstruct.*;

import java.util.List;

/**
 * <b>IComponentMapper</b>
 * <p>
 * This class specifies the requirements for the {@link IComponentMapper} component,
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


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface IComponentMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ComponentDto toDto(Component component);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Component toEntity(ComponentDto componentDto);

    List<ComponentDto> toDtoList(List<Component> componentList);
}
