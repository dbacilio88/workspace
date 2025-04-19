package com.bacsystem.landing.microservice.components.interfaces;

/**
 * <b>ICrud</b>
 * <p>
 * This class specifies the requirements for the {@link ICrud} component,
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

public interface ICrud<E, I> extends IFindAll<E>, IFindById<E, I>, ISave<E>, IUpdate<E>, IDelete<I> {
}