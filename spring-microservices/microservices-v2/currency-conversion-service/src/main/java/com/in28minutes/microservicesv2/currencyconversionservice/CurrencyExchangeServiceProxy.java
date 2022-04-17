package com.in28minutes.microservicesv2.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url = "localhost:8000")
@FeignClient(name="currency-exchange-service")
//@FeignClient(name="netflix-zuul-proxy-server")
public interface CurrencyExchangeServiceProxy {
    
    @GetMapping(value="currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean getExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to);
}
