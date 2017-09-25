package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.PropertiesBean;

public class PropertiesExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/propertiesDemo.xml");
		
		PropertiesBean normalBean = context.getBean("pb", com.teja.di.beans.PropertiesBean.class);
		normalBean.printDBDetails();
		System.out.println("--------------------------------------------------------");
		PropertiesBean utilEg = context.getBean("pb2", com.teja.di.beans.PropertiesBean.class);
		utilEg.printDBDetails();
	}
}
