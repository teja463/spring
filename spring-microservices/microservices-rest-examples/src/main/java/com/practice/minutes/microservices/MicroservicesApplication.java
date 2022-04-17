package com.practice.minutes.microservices;

import com.practice.minutes.microservices.domain.User;
import com.practice.minutes.microservices.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class MicroservicesApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}


	@Bean
	public CommandLineRunner data(){
		return (s) -> {
			Instant now = Instant.now();
			Instant minus = now.minus(Duration.ofDays(20));
			Date from = Date.from(minus);
			userRepository.save(new User("Teja", from));
			userRepository.save(new User("Ramya", from));
			userRepository.save(new User("Havish", from));
		};
	}

}
