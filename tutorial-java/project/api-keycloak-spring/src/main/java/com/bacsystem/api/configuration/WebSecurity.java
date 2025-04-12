package com.bacsystem.api.configuration;

/**
 * <b>WebSecurity</b>
 * <p>
 * This class specifies the requirements for the {@link WebSecurity} component,
 * developed in accordance with the development standards established by bxcode.
 * Collaboration is encouraged for the enhancement and expansion of the api-keycloak-spring.
 * </p>
 * <p>
 * <b>Description:</b>
 * </p>Here!</p>
 *
 * @author bxcode
 * @author dbacilio88@outllok.es
 * @since 3/5/2025
 */
/*
@Log4j2
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
@RequiredArgsConstructor
public class WebSecurity {

    private final GrandAuthoritiesConverter grandAuthoritiesConverter;

    @Bean
    public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        log.info("loading SessionAuthenticationStrategy");
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("loading SecurityFilterChain {}", http);

        http.authorizeRequests(request -> request.anyRequest().authenticated());

        http.oauth2ResourceServer(oauth -> oauth
                .jwt(jwt -> jwt.jwtAuthenticationConverter(grandAuthoritiesConverter)));

        http.csrf(AbstractHttpConfigurer::disable);

        http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));

        return http.build();
    }
}

 */
