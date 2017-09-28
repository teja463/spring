package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.SingletonBean;

public class SingletonExample {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/singleton.xml");
		SingletonBean bean1 = context.getBean("sb1", com.teja.di.beans.SingletonBean.class);
		SingletonBean bean2 = context.getBean("sb2", com.teja.di.beans.SingletonBean.class);
		
		System.out.println(bean1==bean2);
		
	}
}
