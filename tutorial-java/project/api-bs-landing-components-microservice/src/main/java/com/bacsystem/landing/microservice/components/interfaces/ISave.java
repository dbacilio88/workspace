package com.bacsystem.landing.microservice.components.interfaces;

/**
 * <b>ISave</b>
 * <p>
 * This class specifies the requirements for the {@link ISave} component,
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


public interface ISave<E> {

    /**
     * Method saves an entity to the database.
     *
     * @param e the entity to save.
     * @return E the entity to save
     */

    E save(E e);
}
