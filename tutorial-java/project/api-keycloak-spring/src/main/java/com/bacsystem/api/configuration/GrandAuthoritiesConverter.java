package com.bacsystem.api.configuration;


/**
 * <b>GrandAuthoritiesConverter</b>
 * <p>
 * This class specifies the requirements for the {@link GrandAuthoritiesConverter} component,
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
@Component
public class GrandAuthoritiesConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
    private final String principalAttributeName = "preferred_username";
    private final String resourceId = "spring-project-client-id";


    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        var authorities = Stream.concat(jwtGrantedAuthoritiesConverter
                        .convert(jwt)
                        .stream(),
                extractResourceRoles(jwt)
                        .stream()
        ).collect(Collectors.toSet());

        return new JwtAuthenticationToken(
                jwt,
                authorities,
                getPrincipalClaimName(jwt)
        );
    }

    private String getPrincipalClaimName(Jwt jwt) {
        String claimName = JwtClaimNames.SUB;
        if (principalAttributeName != null) {
            claimName = principalAttributeName;
        }
        return jwt.getClaim(claimName);
    }

    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String, Object> resourceAccess;
        Map<String, Object> resources;
        Collection<String> resourceRoles;
        if (jwt.getClaim("resource_access") == null) {
            return Set.of();
        }
        resourceAccess = jwt.getClaim("resource_access");
        if (resourceAccess.get(resourceId) == null) {
            return Set.of();
        }

        resources = (Map<String, Object>) resourceAccess.get(resourceId);
        resourceRoles = (Collection<String>) resources.get("roles");

        return resourceRoles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toSet());
    }
}

 */
