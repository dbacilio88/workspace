package com.bacsystem.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>KeyCloakController</b>
 * <p>
 * This class specifies the requirements for the {@link KeyCloakController} component,
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


@RestController
public class KeyCloakController {

    @GetMapping("/test")
    public ResponseEntity<String> getKeyCloak() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
