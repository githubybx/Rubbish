package com.rubbish.rubbishconfigserver3344;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class RubbishConfigServer3344Application {

    public static void main(String[] args) {
        SpringApplication.run(RubbishConfigServer3344Application.class, args);
    }

}
