package com.teja.driver;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.teja.beans.Bean1;

public class Main {

	public static void main(String[] args) {
		
		
		/** Approach1 using BeanFactory */
		/*Resource resource = new ClassPathResource("resources/spring.xml");
		BeanFactory factory = new XmlBeanFactory(resource);*/
		
		/** Approach 2 using Application Context */
		ApplicationContext factory = new ClassPathXmlApplicationContext("resources/spring.xml");
		
		
		Bean1 bean1 = (Bean1)factory.getBean("bean1");
		bean1.sayHello();
		
		Bean1 bean2 = (Bean1)factory.getBean("bean1");
		bean2.sayHello();
		
		Bean1 bean3 = (Bean1)factory.getBean("bean1");
		bean3.sayHello();
	}
}
