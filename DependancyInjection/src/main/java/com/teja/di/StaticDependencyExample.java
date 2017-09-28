package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.StaticDependencyBean;

public class StaticDependencyExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/staticDI.xml");
		StaticDependencyBean bean = context.getBean("sdb", com.teja.di.beans.StaticDependencyBean.class);
		bean.printData();
	}
}
