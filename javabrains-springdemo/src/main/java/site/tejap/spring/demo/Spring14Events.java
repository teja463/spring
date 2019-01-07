package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle14;


public class Spring14Events {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring14.xml");
		Triangle14 bean = (Triangle14) context.getBean("triangle14");
		bean.draw();
		context.registerShutdownHook();
	}
}
