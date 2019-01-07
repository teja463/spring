package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle11;


public class Spring11AutowiredAnnotation {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring11.xml");
		Triangle11 bean = (Triangle11) context.getBean("triangle");
		bean.draw();
		
	}
}
