package site.tejap.spring.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.beans.Triangle08;


public class Spring08LifecycleCallbacks {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring08.xml");
		Triangle08 bean = (Triangle08) context.getBean("triangle");
		bean.draw();
		
		Triangle08 bean2 = (Triangle08) context.getBean("triangle2");
		bean2.draw();
		
		context.close();
	}
}
