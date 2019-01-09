package site.tejap.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.dao.CircleDaoImpl07;
import site.tejap.spring.dto.Circle02;

public class SpringData07HibernateIntegration {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring07.xml");
		CircleDaoImpl07 dao = context.getBean("circleDaoImpl07", CircleDaoImpl07.class);
		
		Circle02 circle = dao.getCircle(1);
		System.out.println(circle);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
