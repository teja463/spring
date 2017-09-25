package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.DependancyCheckBean;

public class DependancyCheckExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/dependancyCheck.xml");
		DependancyCheckBean bean = context.getBean("dc",com.teja.di.beans.DependancyCheckBean.class);
		bean.printData();
	}
}
