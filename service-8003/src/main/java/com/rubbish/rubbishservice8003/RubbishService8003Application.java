package com.rubbish.rubbishservice8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class RubbishService8003Application {

    public static void main(String[] args) {
        SpringApplication.run(RubbishService8003Application.class, args);
    }

}
