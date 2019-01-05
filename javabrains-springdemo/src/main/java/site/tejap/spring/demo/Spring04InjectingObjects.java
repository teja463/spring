package site.tejap.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle03;


public class Spring04InjectingObjects {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring04.xml");
		Triangle03 bean = (Triangle03) context.getBean("triangle");
		bean.draw();
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
