package com.bacsystem.landing.microservice;

import com.bacsystem.landing.microservice.components.base.ApplicationBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.bacsystem.landing.microservice"}
)
public class Application extends ApplicationBase {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
