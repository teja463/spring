package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.UtilCollections;

public class UtilCollectionsExample {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/utilCollections.xml");
		UtilCollections bean = context.getBean("uce", com.teja.di.beans.UtilCollections.class);
		bean.printData();
	}
}
