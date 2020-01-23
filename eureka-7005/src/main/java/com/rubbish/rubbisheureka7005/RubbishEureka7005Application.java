package com.rubbish.rubbisheureka7005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RubbishEureka7005Application {

    public static void main(String[] args) {
        SpringApplication.run(RubbishEureka7005Application.class, args);
    }

}
