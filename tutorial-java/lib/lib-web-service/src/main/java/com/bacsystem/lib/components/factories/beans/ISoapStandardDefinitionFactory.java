package com.bacsystem.lib.components.factories.beans;


import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapStandardDefinition;

/**
 * <b>ISoapStandardDefinitionFactory</b>
 * <p>
 * This class specifies the requirements for the {@link ISoapStandardDefinitionFactory} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Interfaz para la fábrica de definiciones estándar de SOAP.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */

public interface ISoapStandardDefinitionFactory {

    /**
     * Crea una instancia de {@link ISoapStandardDefinition} basada en una cadena de definición.
     *
     * @param definition La cadena que representa la definición estándar de SOAP.
     * @return Una instancia de {@link ISoapStandardDefinition}.
     * @throws IllegalArgumentException Si la definición es nula o vacía.
     */
    ISoapStandardDefinition factory(String definition);
}
