package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.NamespaceBean;

public class NamespaceExample {

	public static void main(String[] args) {
		ApplicationContext context  = new ClassPathXmlApplicationContext("resources/namespace.xml");
		NamespaceBean bean = context.getBean("ne", com.teja.di.beans.NamespaceBean.class);
		bean.printData();
	}
}
