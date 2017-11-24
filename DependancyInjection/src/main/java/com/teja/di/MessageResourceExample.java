package com.teja.di;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageResourceExample {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/messageResource.xml");
		String enMsg = context.getMessage("label.name", null, Locale.US);
		String frMsg = context.getMessage("label.name", null, Locale.FRANCE);
		System.out.println(enMsg);
		System.out.println(frMsg);
		
		
		String enAge = context.getMessage("label.age", new Object[]{28}, Locale.US);
		String frAge = context.getMessage("label.age", new Object[]{28}, Locale.FRANCE);
		
		System.out.println(enAge);
		System.out.println(frAge);
	}
}
