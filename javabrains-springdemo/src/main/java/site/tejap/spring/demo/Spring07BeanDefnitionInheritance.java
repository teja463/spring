package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle07;


public class Spring07BeanDefnitionInheritance {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring07.xml");
		Triangle07 bean = (Triangle07) context.getBean("triangle");
		bean.draw();
		
		Triangle07 bean2 = (Triangle07) context.getBean("anotherTriangle");
		bean2.draw();
		
		context.registerShutdownHook();
	}
}
