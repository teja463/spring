package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle10;


public class Spring10RequiredAnnotation {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring10.xml");
		Triangle10 bean = (Triangle10) context.getBean("triangle");
		bean.draw();
		
	}
}
