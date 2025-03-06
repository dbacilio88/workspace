package com.bacsystem.lib.components.factories.beans;

import com.bacsystem.lib.components.base.SoapBase;
import com.bacsystem.lib.components.exceptions.SoapProcessException;
import com.bacsystem.lib.components.factories.abstracts.contracts.ISoapCustomDefinition;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

/**
 * <b>SoapCustomDefinitionFactory</b>
 * <p>
 * This class specifies the requirements for the {@link SoapCustomDefinitionFactory} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the lib-web-service.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Fábrica para crear definiciones personalizadas de SOAP. Esta clase implementa ISoapCustomDefinitionFactory.</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 2/28/2025
 */


@Log4j2
@Component
public class SoapCustomDefinitionFactory extends SoapBase implements ISoapCustomDefinitionFactory {

    private final BeanFactory beanFactory;

    public SoapCustomDefinitionFactory(BeanFactory beanFactory) {
        super(SoapCustomDefinitionFactory.class.getSimpleName());
        this.beanFactory = beanFactory;
    }

    @Override
    public ISoapCustomDefinition factory(String definition) {
        // Comprobar si la definición es nula o vacía
        if (definition == null || definition.isEmpty()) {
            throw new SoapProcessException("definition is null or empty");
        }
        // Crear y retornar una nueva instancia de ISoapCustomDefinition utilizando el BeanFactory
        log.debug("factory bean soap custom: {}, definition: {}", beanFactory, definition);
        return beanFactory.getBean(definition, ISoapCustomDefinition.class);
    }
}
