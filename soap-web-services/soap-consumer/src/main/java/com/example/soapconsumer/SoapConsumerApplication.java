package com.example.soapconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapConsumerApplication {


	public static void main(String[] args) {

		SpringApplication.run(SoapConsumerApplication.class, args);

		MyWsClient client = new MyWsClient();
		client.sendCountryRequest("Spain");
		client.sendCountryRequest("Poland");
	}


}
