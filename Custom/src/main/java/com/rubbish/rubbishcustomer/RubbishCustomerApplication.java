package com.rubbish.rubbishcustomer;

import com.rubbish.myRyle.MySelRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "Rubbish-Server",configuration = MySelRule.class)
public class RubbishCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RubbishCustomerApplication.class, args);
    }

}
