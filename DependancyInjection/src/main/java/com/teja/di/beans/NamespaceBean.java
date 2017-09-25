package com.teja.di.beans;

public class NamespaceBean {

	private String name;
	private String email;
	
	public NamespaceBean(String name){
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printData() {
		System.out.println(name +" "+email);
	}
}
