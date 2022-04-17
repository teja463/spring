package com.in28minutes.microservicesv2.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){
        Map<String, String> input = new HashMap<>();
        input.put("from", from);
        input.put("to", to);
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, input);
        CurrencyConversionBean response = responseEntity.getBody();

        response.setQuantity(quantity);
        response.setConversionMultiple(quantity.multiply(response.getConversionMultiple()));
        return response;
    }

    @GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){
        CurrencyConversionBean exchangeRate = currencyExchangeServiceProxy.getExchangeRate(from, to);
        exchangeRate.setQuantity(quantity);
        exchangeRate.setConversionMultiple(quantity.multiply(exchangeRate.getConversionMultiple()));
        logger.info("currency conversion bean {}", exchangeRate);
        return exchangeRate;
    }
}
