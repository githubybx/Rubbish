package com.rubbish.rubbishservice8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class RubbishService8002Application {

    public static void main(String[] args) {
        SpringApplication.run(RubbishService8002Application.class, args);
    }

}
