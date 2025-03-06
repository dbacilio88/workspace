package com.bacsystem.lib.components.factories.beans;

import com.bacsystem.lib.components.base.SoapBase;
import com.bacsystem.lib.components.exceptions.SoapProcessException;
import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapStandardDefinition;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

/**
 * <b>SoapStandardDefinitionFactory</b>
 * <p>
 * This class specifies the requirements for the {@link SoapStandardDefinitionFactory} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Fábrica para crear definiciones estándar de SOAP. Esta clase implementa ISoapStandardDefinitionFactory.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
@Component
public class SoapStandardDefinitionFactory extends SoapBase implements ISoapStandardDefinitionFactory {

    private final BeanFactory beanFactory;

    public SoapStandardDefinitionFactory(BeanFactory beanFactory) {
        super(SoapStandardDefinitionFactory.class.getSimpleName());
        this.beanFactory = beanFactory;
    }

    @Override
    public ISoapStandardDefinition factory(String definition) {
        // Comprobar si la definición es nula o vacía
        if (definition == null || definition.isEmpty()) {
            throw new SoapProcessException("definition is null or empty");
        }

        log.debug("factory bean soap standard: {}, definition: {}", beanFactory, definition);
        // Crear y retornar una nueva instancia de ISoapStandardDefinition utilizando el BeanFactory
        return beanFactory.getBean(definition, ISoapStandardDefinition.class);
    }
}
