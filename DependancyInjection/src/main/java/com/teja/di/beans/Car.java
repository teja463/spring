package com.teja.di.beans;

public class Car {

	private String make;
	private Engine engine;
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void printData(){
		System.out.println("Car make : "+make+ " Model year : "+engine.getModelYear());
	}
}
