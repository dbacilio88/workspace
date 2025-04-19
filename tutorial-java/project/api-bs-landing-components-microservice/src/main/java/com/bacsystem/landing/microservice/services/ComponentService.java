package com.bacsystem.landing.microservice.services;

import com.bacsystem.landing.microservice.components.base.process.ProcessResponse;
import com.bacsystem.landing.microservice.components.base.response.GenericResponse;
import com.bacsystem.landing.microservice.components.enums.ResponseCode;
import com.bacsystem.landing.microservice.components.exceptions.ApplicationException;
import com.bacsystem.landing.microservice.components.services.ReactiveRedisCacheService;
import com.bacsystem.landing.microservice.repositories.IComponentRepository;
import com.bacsystem.landing.microservice.services.contracts.IComponentService;
import com.bacsystem.landing.microservice.services.mapper.IComponentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * <b>ComponentService</b>
 * <p>
 * This class specifies the requirements for the {@link ComponentService} component,
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

@Log4j2
@Service
@AllArgsConstructor
public class ComponentService implements IComponentService {

    private final IComponentRepository componentRepository;
    private final IComponentMapper componentMapper;
    private final ReactiveRedisCacheService reactiveRedisCacheService;


    @Override
    @Cacheable("components")
    public Mono<ProcessResponse> doOnProcess() {

        return Mono.defer(() -> this.componentRepository
                        .findAll(Sort.by(Sort.Direction.DESC, "name"))
                        .collectList()
                        .map(component -> ProcessResponse.success(new GenericResponse<>(componentMapper.toDtoList(component)))))
                .onErrorResume(throwable -> {
                    log.error("error processing components {}", throwable.getMessage(), throwable);
                    return Mono.error(new ApplicationException("error processing", ResponseCode.NOT_FOUND));
                });
    }
}
