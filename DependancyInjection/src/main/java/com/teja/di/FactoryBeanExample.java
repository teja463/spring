package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.Shape;

public class FactoryBeanExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/factoryBeanExample.xml");
		Shape bean1 = context.getBean("triangle", com.teja.di.beans.Shape.class);
		Shape bean2 = context.getBean("triangle", com.teja.di.beans.Shape.class);
		System.out.println(bean1);
		System.out.println(bean2);
		System.out.println(bean1==bean2);
	}
}
