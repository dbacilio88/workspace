package com.bacsystem.landing.microservice.components.interfaces;

/**
 * <b>IDelete</b>
 * <p>
 * This class specifies the requirements for the {@link IDelete} component,
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


public interface IDelete<I> {

    /**
     * Method deletes an entity from the database.
     *
     * @param id the entity to delete
     */
    long delete(I id);
}