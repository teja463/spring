package com.teja.di.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class LifecycleBean implements InitializingBean, DisposableBean{

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set");
	}

	public void destroy() throws Exception {
		System.out.println("Before closing the context");
	}

	public void printData(){
		System.out.println("Name: "+name);
	}
}
