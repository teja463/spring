package com.in28minutes.microservices.netflixzuulproxyserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class NetflixZuulProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulProxyServerApplication.class, args);
	}

	@Bean
	public Sampler forAll(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
