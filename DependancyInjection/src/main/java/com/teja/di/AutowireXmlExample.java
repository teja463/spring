package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.AutowireXmlBean;

public class AutowireXmlExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/autowireXmlBased.xml");
		AutowireXmlBean bean = context.getBean("axb2", com.teja.di.beans.AutowireXmlBean.class);
		bean.printData();
	}
}
