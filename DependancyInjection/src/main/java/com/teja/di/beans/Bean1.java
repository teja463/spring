package com.teja.di.beans;

public class Bean1 {

	private String gender;
	
	public void setGender(String gender){
		this.gender = gender;
	}
	public void sayHello(String name){
		System.out.println("Hello.. "+gender +" "+name);
	}
}
