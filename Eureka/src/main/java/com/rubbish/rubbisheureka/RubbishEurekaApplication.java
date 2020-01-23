package com.rubbish.rubbisheureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RubbishEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RubbishEurekaApplication.class, args);
    }

}
