package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.ConstructorBean;

public class ConstructorExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");
		ConstructorBean bean = context.getBean("constructBean", com.teja.di.beans.ConstructorBean.class);
		
		bean.sayHello("Teja");
		
	}
}
