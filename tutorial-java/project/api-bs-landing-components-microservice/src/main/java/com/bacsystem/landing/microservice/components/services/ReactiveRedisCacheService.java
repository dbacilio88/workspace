package com.bacsystem.landing.microservice.components.services;

import lombok.AllArgsConstructor;
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

@Component
@AllArgsConstructor
public class ReactiveRedisCacheService {

    private final Map<Class<?>, ReactiveRedisTemplate<String, ?>> templateCache = new ConcurrentHashMap<>();


    private <T> ReactiveRedisTemplate<String, T> getTemplate(Class<T> clazz) {
        return (ReactiveRedisTemplate<String, T>) templateCache
                .computeIfAbsent(clazz, templateFactory::createTemplate);
    }
    public Mono<Boolean> save(String key, T value, Duration duration) {
        return redisTemplate.opsForValue().set(key, value, duration);
    }

    public Mono<T> get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Mono<Boolean> delete(String key) {
        return this.redisTemplate.delete(key).map(count -> count > 0);
    }
}
