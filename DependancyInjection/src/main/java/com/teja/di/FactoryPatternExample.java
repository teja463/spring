package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.Shape;

public class FactoryPatternExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/factoryPattern.xml");
		Shape bean = context.getBean("square", com.teja.di.beans.Shape.class);
		
		bean.draw();
	}
}
