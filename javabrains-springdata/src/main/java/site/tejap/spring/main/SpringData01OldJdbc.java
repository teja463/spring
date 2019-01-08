package site.tejap.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.dao.CircleDaoImpl;
import site.tejap.spring.dto.Circle;

public class SpringData01OldJdbc {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring01.xml");
		CircleDaoImpl dao = context.getBean("circleDaoImpl", CircleDaoImpl.class);
		Circle circle = dao.getCircle(2);
		System.out.println(circle);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
