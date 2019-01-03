package site.tejap.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle01;


public class Spring02ApplicationContextSetterInjectionDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring02.xml");
		Triangle01 bean = (Triangle01) context.getBean("triangle");
		bean.draw();
	}
}
