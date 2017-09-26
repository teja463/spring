package com.teja.di.beans;

public class AutowireXmlBean {

	private Engine engine;
	
	public AutowireXmlBean(Engine engine){
		System.out.println("Autowiring using parameterised constructor");
		this.engine = engine;
	}
	
	public AutowireXmlBean(){
		System.out.println("AUtowirking using default constructor");
	}
	
	public void setEngine(Engine engine) {
		System.out.println("Autowiring using setter DI");
		this.engine = engine;
	}
	
	public void printData(){
		System.out.println(engine);
	}
	
}
