package com.rubbish.rubbishconfigclient.Config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class ConfigClentRest {
    @Value("${spring.application.name}")
    public String applicationName;
    @Value("${server.port}")
    public String port;
    @RequestMapping("/config")
    public String getConfig(){
        System.out.println(applicationName + " " + port);
        return applicationName + " " + port;
    }

}
