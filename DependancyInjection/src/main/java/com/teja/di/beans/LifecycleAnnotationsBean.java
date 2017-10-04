package com.teja.di.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class LifecycleAnnotationsBean {

	@PostConstruct
	public void init(){
		System.out.println("Post construct");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Pre destroy");
	}
}
