package com.in28minutes.microservices.currencyexchangeservice;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class CurrencyExchangeServiceApplication {

	@Autowired
	ExchangeValueRepository exchangeValueRepository;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertData(){
		return args -> {
			ExchangeValue usd = new ExchangeValue(1001L,"USD", "INR", BigDecimal.valueOf(75));
			ExchangeValue eur = new ExchangeValue(1002L,"EUR", "INR", BigDecimal.valueOf(85));
			ExchangeValue pound = new ExchangeValue(1003L,"GBP", "INR", BigDecimal.valueOf(101));
			exchangeValueRepository.save(usd);
			exchangeValueRepository.save(eur);
			exchangeValueRepository.save(pound);
		};
	}

	@Bean
	public Sampler forAll(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
