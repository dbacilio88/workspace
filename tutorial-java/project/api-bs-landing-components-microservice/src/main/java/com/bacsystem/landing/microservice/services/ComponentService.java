package com.bacsystem.landing.microservice.services;

import com.bacsystem.landing.microservice.components.base.process.ProcessResponse;
import com.bacsystem.landing.microservice.components.base.response.GenericResponse;
import com.bacsystem.landing.microservice.components.constants.LoggerConstant;
import com.bacsystem.landing.microservice.components.constants.MongoConstant;
import com.bacsystem.landing.microservice.components.constants.RedisConstant;
import com.bacsystem.landing.microservice.components.enums.ResponseCode;
import com.bacsystem.landing.microservice.components.exceptions.ApplicationException;
import com.bacsystem.landing.microservice.components.services.ReactiveRedisCacheService;
import com.bacsystem.landing.microservice.repositories.IComponentRepository;
import com.bacsystem.landing.microservice.services.contracts.IComponentService;
import com.bacsystem.landing.microservice.services.mapper.IComponentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

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
    public Mono<ProcessResponse> doOnProcess(final ServerRequest request) {
        return this.reactiveRedisCacheService.get(RedisConstant.KEY_MEMORY_COMPONENTS, List.class)
                .cast(List.class)
                .map(list -> ProcessResponse.success(new GenericResponse<>(list)))
                .switchIfEmpty(componentRepository.findAll(Sort.by(Sort.Direction.DESC, MongoConstant.FIELD_MONGO_COMPONENT_NAME))
                        .collectList()
                        .map(this.componentMapper::toDtoList)
                        .flatMap(result -> this.reactiveRedisCacheService.save(RedisConstant.KEY_MEMORY_COMPONENTS, result, Duration.ofSeconds(10), List.class)
                                .thenReturn(ProcessResponse.success(new GenericResponse<>(result))))
                )
                .onErrorResume(throwable -> {
                    log.error(throwable.getMessage(), throwable);
                    return Mono.error(new ApplicationException(LoggerConstant.LOG_MESSAGE_ERROR_COMPONENTS, ResponseCode.NOT_FOUND));
                });
    }
}
