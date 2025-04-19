package com.bacsystem.landing.microservice.services;

import com.bacsystem.landing.microservice.components.base.process.ProcessResponse;
import com.bacsystem.landing.microservice.components.base.response.GenericResponse;
import com.bacsystem.landing.microservice.services.contracts.IComponentService;
import lombok.extern.log4j.Log4j2;
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
public class ComponentService implements IComponentService {
    @Override
    public Mono<ProcessResponse> doOnProcess() {
        final GenericResponse<String> response = new GenericResponse<>("Hello World");
        return Mono.just(ProcessResponse.success(response));
    }
}
