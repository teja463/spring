package com.teja.spring.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.teja.spring.ioc.ShowRoom;
import com.teja.spring.ioc.beans.Puma;
import com.teja.spring.ioc.beans.Shoe;

@Configuration
public class AppConfig {

	@Bean(name="shoe")
//	@Scope("prototype")
	public Shoe getShoe(){
		return new Shoe();
	}
	
	@Bean(name="pumaShoe")
//	@Scope("prototype")
	public Shoe getPumaShoe(){
		return new Puma();
	}
	
	@Bean(name="shoe2")
	@Scope("prototype")
	public Shoe getShoe2(){
		return new Shoe();
	}
	
	@Bean(name="showRoom")
	public ShowRoom getShowRoom(){
		return new ShowRoom();
	}
}
