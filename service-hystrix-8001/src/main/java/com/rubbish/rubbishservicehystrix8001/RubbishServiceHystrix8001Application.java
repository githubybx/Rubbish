package com.rubbish.rubbishservicehystrix8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class RubbishServiceHystrix8001Application {

    public static void main(String[] args) {
        SpringApplication.run(RubbishServiceHystrix8001Application.class, args);
    }

}
