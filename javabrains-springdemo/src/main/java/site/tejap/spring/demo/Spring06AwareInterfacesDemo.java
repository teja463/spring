package site.tejap.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle06;


public class Spring06AwareInterfacesDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring06.xml");
		Triangle06 bean = (Triangle06) context.getBean("triangle");
		bean.draw();
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
