package com.in28minutes.microservicesv2.currencyexchange.service;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
    @Retry(name = "default", fallbackMethod = "sampleAPIFallback")
//    @Retry(name = "sample", fallbackMethod = "sampleAPIFallback")
    public String sampleAPI(){
        logger.info("sample API called");
        sample();
        return "Sample API";
    }

    public String sampleAPIFallback(Exception e){
        return "Fallback Response";
    }
    private void sample() {
        throw new RuntimeException("Sample");
    }
}
