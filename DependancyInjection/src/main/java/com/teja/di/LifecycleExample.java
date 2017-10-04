package com.teja.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.LifecycleBean;

public class LifecycleExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/lifecycle.xml");
		LifecycleBean bean = context.getBean("lb", com.teja.di.beans.LifecycleBean.class);
		bean.printData();
		context.close();
		
	}
}
