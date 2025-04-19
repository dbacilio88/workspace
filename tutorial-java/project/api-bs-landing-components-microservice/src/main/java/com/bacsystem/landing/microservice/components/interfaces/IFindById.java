package com.bacsystem.landing.microservice.components.interfaces;

/**
 * <b>IFindById</b>
 * <p>
 * This class specifies the requirements for the {@link IFindById} component,
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


public interface IFindById<E, I> {

    /**
     * @param id The identifier of the entity to find.
     * @return E The found entity, or null if not found.
     */
    E findById(I id);
}