package com.in28minutes.microservices.currencyexchangeservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @HystrixCommand(fallbackMethod = "getExchangeValueFallback")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable  String to){
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("Exchange Value {}", exchangeValue);
        return exchangeValue;
    }

    public ExchangeValue getExchangeValueFallback(@PathVariable String from, @PathVariable  String to){
        ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setPort(0000);
        exchangeValue.setConversionMultiple(BigDecimal.valueOf(0));
        exchangeValue.setFrom(from);
        exchangeValue.setTo(to);
        return exchangeValue;
    }
}
