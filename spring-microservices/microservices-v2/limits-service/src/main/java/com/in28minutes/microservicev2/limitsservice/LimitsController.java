package com.in28minutes.microservicev2.limitsservice;

import com.in28minutes.microservicev2.limitsservice.data.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration getLimitConfiguration(){
        return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }
}
