package com.rubbish.rubbishcustomfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.rubbish.rubbishcustomfeign"})
public class RubbishCustomFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(RubbishCustomFeignApplication.class, args);
    }

}
