package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.Bean1;

public class SetterDIExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");
		
		Bean1 bean = context.getBean("bean1", com.teja.di.beans.Bean1.class);
		bean.sayHello("Teja");
	}
}
