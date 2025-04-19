package com.bacsystem.landing.microservice;

import com.bacsystem.landing.microservice.repositories.IComponentRepository;
import com.bacsystem.landing.microservice.repositories.docs.Component;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Log4j2
@AllArgsConstructor
@SpringBootApplication(
        scanBasePackages = {"com.bacsystem.landing.microservice"}
)
public class Application implements CommandLineRunner {

    private final IComponentRepository componentRepository;
    private final ReactiveMongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        mongoTemplate.dropCollection(Component.class)
                .subscribe();
        Flux.just(
                        Component.builder().name("Object1").build(),
                        Component.builder().name("Object2").build(),
                        Component.builder().name("Object3").build(),
                        Component.builder().name("Object4").build(),
                        Component.builder().name("Object5").build()
                ).flatMap(this.componentRepository::save)
                .doOnNext(component -> log.debug("next save {}", component))
                .subscribe(component -> log.debug("Insert {}", component));

        var components = componentRepository.findAll()
                .map(component -> {
                    component.setName(component.getName().toUpperCase());
                    return component;
                })
                //.repeat(20)
                .delayElements(Duration.ofSeconds(1));

        //thymeleaf ReactiveDataDriverContextVariable
        components
                .doOnNext(component -> log.debug("next find {}", component))
                .subscribe(component -> log.debug("Subscribed {}", component));
    }
}
