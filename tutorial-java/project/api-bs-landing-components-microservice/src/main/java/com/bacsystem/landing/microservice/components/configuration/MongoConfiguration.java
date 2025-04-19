package com.bacsystem.landing.microservice.components.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * <b>MongoConfiguration</b>
 * <p>
 * This class specifies the requirements for the {@link MongoConfiguration} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the api-bs-landing-components-microservice.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 4/19/2025
 */

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.bacsystem.landing.microservice.repositories")
public class MongoConfiguration {
}
