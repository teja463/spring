package site.tejap.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.dao.CircleDaoImpl06;
import site.tejap.spring.dto.Circle;

public class SpringData06NamedParameter {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring06.xml");
		CircleDaoImpl06 dao = context.getBean("circleDaoImpl06", CircleDaoImpl06.class);
		
		Circle circle = dao.getCircle(7);
		System.out.println(circle);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
