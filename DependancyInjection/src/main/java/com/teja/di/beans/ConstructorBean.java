package com.teja.di.beans;

public class ConstructorBean {

	private String gender;
	private int age;
	private String email;
		
	public ConstructorBean(String gender, int age, String email){
		this.gender = gender;
		this.age = age;
		this.email = email;
	}
	
	public void sayHello(String name){
		System.out.println("Hello.. "+ gender+" "+name +" Age: "+age +" Email: "+email);
	}
}
