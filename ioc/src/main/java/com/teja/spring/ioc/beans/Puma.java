package com.teja.spring.ioc.beans;

public class Puma extends Shoe {

	public Puma(){
		System.out.println("Puma shoe object created");
	}
	
	public void wear(){
		System.out.println("Wearing the Puma shoe");
	}
}
