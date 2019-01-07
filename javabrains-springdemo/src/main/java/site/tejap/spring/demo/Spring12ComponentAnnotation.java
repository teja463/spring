package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle12;


public class Spring12ComponentAnnotation {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring12.xml");
		Triangle12 bean = (Triangle12) context.getBean("triangle12");
		bean.draw();
		
	}
}
