package com.teja.di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("aab")
public class AutowireAnnotationBean {

	@Autowired
	@Qualifier(value="e1")
	private Engine engine;
	
	public void printData(){
		System.out.println(engine);
	}
	
}
