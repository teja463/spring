package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.AutowireAnnotationBean;

public class AutowireAnnotationExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/autowireAnnotationBased.xml");
		AutowireAnnotationBean bean = context.getBean("aab", com.teja.di.beans.AutowireAnnotationBean.class);
		bean.printData();
	}
}
