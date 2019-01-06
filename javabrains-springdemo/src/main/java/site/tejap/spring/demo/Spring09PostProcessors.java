package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle08;
import site.tejap.spring.beans.Triangle09;


public class Spring09PostProcessors {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring09.xml");
		Triangle09 bean = (Triangle09) context.getBean("triangle");
		bean.draw();
		
		Triangle09 bean2 = (Triangle09) context.getBean("triangle2");
		bean2.draw();
		
		context.close();
	}
}
