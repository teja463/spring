package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.LifecycleXmlBean;

public class LifecycleXmlExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/lifecycleXmlBased.xml");
		LifecycleXmlBean bean = context.getBean("lxb", com.teja.di.beans.LifecycleXmlBean.class);
		bean.printData();
		context.close();
		
	}
}
