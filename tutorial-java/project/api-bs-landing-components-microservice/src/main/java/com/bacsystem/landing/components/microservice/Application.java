package com.bacsystem.landing.components.microservice;

import com.bacsystem.landing.components.microservice.components.base.ApplicationBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.bacsystem.landing.components.microservice"}
)
public class Application extends ApplicationBase {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
