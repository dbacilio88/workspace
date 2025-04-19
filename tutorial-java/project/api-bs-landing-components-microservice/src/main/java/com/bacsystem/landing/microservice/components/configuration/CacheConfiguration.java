package com.bacsystem.landing.microservice.components.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <b>CacheConfiguration</b>
 * <p>
 * This class specifies the requirements for the {@link CacheConfiguration} component,
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
@AllArgsConstructor
public class CacheConfiguration {

    private final ReactiveRedisConnectionFactory connectionFactory;

    public <T> ReactiveRedisTemplate<String, T> createTemplate(Class<T> clazz) {
        RedisSerializationContext<String, T> context = RedisSerializationContext
                .<String, T>newSerializationContext(new StringRedisSerializer())
                .value(new Jackson2JsonRedisSerializer<>(clazz))
                .build();

        return new ReactiveRedisTemplate<>(connectionFactory, context);
    }
}
