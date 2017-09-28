package com.teja.di.beans;

import org.springframework.stereotype.Component;

public class StaticDependencyBean {

	private static String name;
	
	public static void setName(String name) {
		StaticDependencyBean.name = name;
	}
	
	public void printData(){
		System.out.println("Name: "+StaticDependencyBean.name);
	}
}
