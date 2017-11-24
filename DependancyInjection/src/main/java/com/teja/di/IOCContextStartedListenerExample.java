package com.teja.di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCContextStartedListenerExample {

	public static void main(String[] args) {
		
		/* start method is not available in ApplicationContext interface. 
		 * We need to use ConfigurableApplicationContext interface to use lifecycle methods. 
		 */
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("resources/contextListener.xml");
		context.start();
		
	}
}
