package com.bacsystem.lib.components.factories.abstracts.mappers;

/**
 * <b>ISoapRequestMapper</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapRequestMapper} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Proporciona un método para convertir un objeto de tipo S a un objeto de tipo T.</p>
 *
 * @param <S> Tipo de entrada que se va a mapear.
 * @param <R> Tipo de salida resultante del mapeo.
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface ISoapRequestMapper<S, R> {

    /**
     * Mapea un objeto de tipo S a un objeto de tipo R.
     *
     * @param source El objeto de entrada que se va a mapear.
     * @return El objeto mapeado de tipo R.
     */
    R map(S source);
}
