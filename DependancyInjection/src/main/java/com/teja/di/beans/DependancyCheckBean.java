package com.teja.di.beans;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;

public class DependancyCheckBean {

	private String carName;
	private Engine engine;
	
	@Required
	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Required
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void printData() {
		System.out.println(carName +" "+ engine);
	}
}
