package com.bacsystem.api.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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


@Log4j2
@SuppressWarnings("uncheked")
public class GrandAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        log.info("loading convert Jwt  [{}]", source);

        // capture realm_access
        var mapRealmAccess = source.getClaimAsMap("realm_access");

        if (Objects.nonNull(mapRealmAccess)) {
            List<String> listRoles = (List<String>) mapRealmAccess.get("roles");
            log.info("loading roles [{}]", listRoles);
            // capture roles
            return listRoles.stream()
                    .map(role -> {
                        return new SimpleGrantedAuthority("ROLE_" + role);
                    })
                    .collect(Collectors.toList());
        }


        log.info("loaded convert Jwt  [{}]", source);
        return List.of();
    }
}
