package com.cpinelli.hydra.ep;

import com.cpinelli.hydra.ep.config.EnableHydra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHydra
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
