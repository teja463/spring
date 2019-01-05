package site.tejap.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle05;


public class Spring05Autowired {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring05.xml");
		Triangle05 bean = (Triangle05) context.getBean("triangle");
		bean.draw();
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
