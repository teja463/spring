package site.tejap.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle02;


public class Spring03ConstrucorInjectionDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring03.xml");
		Triangle02 bean = (Triangle02) context.getBean("triangle");
		bean.draw();
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
