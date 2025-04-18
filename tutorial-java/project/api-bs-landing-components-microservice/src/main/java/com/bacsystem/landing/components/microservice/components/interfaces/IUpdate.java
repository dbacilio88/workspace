package com.bacsystem.landing.components.microservice.components.interfaces;

/**
 * <b>IUpdate</b>
 * <p>
 * This class specifies the requirements for the {@link IUpdate} component,
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


public interface IUpdate<E> {

    /**
     * Method updates an existing entity in the database.
     *
     * @param entity The entity with updated data.
     * @return E The updated entity.
     */
    E update(E entity);
}
