package com.bacsystem.landing.microservice.repositories;

import com.bacsystem.landing.microservice.repositories.docs.Component;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <b>IComponentRepository</b>
 * <p>
 * This class specifies the requirements for the {@link IComponentRepository} component,
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

@Repository
public interface IComponentRepository extends ReactiveMongoRepository<Component, String> {


}
