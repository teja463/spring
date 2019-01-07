package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle13;


public class Spring13JSR250AndResourceBundle {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring13.xml");
		Triangle13 bean = (Triangle13) context.getBean("triangle13");
		bean.draw();
		context.registerShutdownHook();
	}
}
