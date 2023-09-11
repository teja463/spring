package com.teja.springbootunittesting2;

import com.teja.springbootunittesting2.entity.Book;
import com.teja.springbootunittesting2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootUnitTesting2Application {

	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootUnitTesting2Application.class, args);
	}

	@Bean
	public CommandLineRunner intializeData(){
		return (args) -> {
			Book one = new Book(null, "Wings of Fire", "7446-5648-5487", "Abdul Kalam");
			Book two = new Book(null, "Three Thousand Stiches", "9383-4729-1837", "Sudha Murthy");
			bookRepository.save(one);
			bookRepository.save(two);


		};
	}

}
