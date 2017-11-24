package com.teja.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.PropertyPlaceHolderBean;

public class PropertyPlaceHolderExample {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/propertyPlaceHolder.xml");
		PropertyPlaceHolderBean bean = context.getBean("pph", com.teja.di.beans.PropertyPlaceHolderBean.class);
		bean.createConnection();
	} 
	
}
