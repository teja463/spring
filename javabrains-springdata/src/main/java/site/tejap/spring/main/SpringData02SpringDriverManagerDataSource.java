package site.tejap.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.dao.CircleDaoImpl02;
import site.tejap.spring.dto.Circle;

public class SpringData02SpringDriverManagerDataSource {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring02.xml");
		CircleDaoImpl02 dao = context.getBean("circleDaoImpl02", CircleDaoImpl02.class);
		Circle circle = dao.getCircle(2);
		System.out.println(circle);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
