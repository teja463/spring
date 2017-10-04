package com.teja.di.beans;

public class LifecycleXmlBean {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void init(){
		System.out.println("After setting properties");
	}
	
	public void destroy(){
		System.out.println("Before closing the context");
	}
	
	public void printData(){
		System.out.println("Name: "+name);
	}
}
