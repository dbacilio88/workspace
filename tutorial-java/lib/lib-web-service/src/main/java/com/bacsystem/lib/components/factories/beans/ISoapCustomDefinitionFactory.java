package com.bacsystem.lib.components.factories.beans;


import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapCustomDefinition;

/**
 * <b>ISoapCustomDefinitionFactory</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapCustomDefinitionFactory} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para la fábrica de definiciones personalizadas de SOAP.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface ISoapCustomDefinitionFactory {

    /**
     * Interfaz para la fábrica de definiciones SOAP personalizadas.
     * Crea una instancia de {@link ISoapCustomDefinition} basada en una cadena de definición.
     *
     * @param definition La cadena que representa la definición SOAP personalizada.
     * @return Una instancia de {@link ISoapCustomDefinition}.
     * @throws IllegalArgumentException Si la definición es nula o vacía.
     */
    ISoapCustomDefinition factory(String definition);

}
