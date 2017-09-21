package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.DefaultCollectionBean;

public class DefaultCollectionExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/defaultCollection.xml");
		
		DefaultCollectionBean bean = context.getBean("dce",com.teja.di.beans.DefaultCollectionBean.class);
		bean.printData();
	}
}
