package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.Car;

public class InnerBeanExample {

	public static void main(String[] args) {
		
		/** Pass by reference example */
		String [] files = {"resources/engine.xml","resources/car.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(files);
		
		Car car = context.getBean("car",com.teja.di.beans.Car.class);
		
		car.printData();
	}
}
