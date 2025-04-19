package com.bacsystem.landing.microservice.components.services;

import com.bacsystem.landing.microservice.components.configuration.CacheConfiguration;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b>ReactiveRedisCacheService</b>
 * <p>
 * This class specifies the requirements for the {@link ReactiveRedisCacheService} component,
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
@Log4j2
@Component
@AllArgsConstructor
public class ReactiveRedisCacheService {

    private final CacheConfiguration cacheConfiguration;

    private final Map<Class<?>, ReactiveRedisTemplate<String, ?>> templateCache = new ConcurrentHashMap<>();


    @SuppressWarnings("unchecked")
    private <T> ReactiveRedisTemplate<String, T> getTemplate(Class<T> clazz) {
        return (ReactiveRedisTemplate<String, T>) templateCache
                .computeIfAbsent(clazz, cacheConfiguration::createTemplate);
    }

    public <T> Mono<Boolean> save(String key, T value, Duration duration, Class<T> clazz) {
        return getTemplate(clazz).opsForValue().set(key, value, duration)
                .doOnNext(result -> log.info("save data in memory is [{}]", result));
    }

    public <T> Mono<T> get(String key, Class<T> clazz) {
        return getTemplate(clazz).opsForValue().get(key)
                .doOnNext(value -> log.info("get data of memory is value: {}", value));
    }

    public Mono<Boolean> delete(String key, Class<?> clazz) {
        return this.getTemplate(clazz)
                .delete(key).map(count -> count > 0)
                .doOnNext(result -> log.info("delete data in memory is [{}]", result));
    }
}
