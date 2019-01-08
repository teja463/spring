package site.tejap.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.dao.CircleDaoImpl03;
import site.tejap.spring.dto.Circle;

public class SpringData03BasicDataSourceConnectionPooling {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring03.xml");
		CircleDaoImpl03 dao = context.getBean("circleDaoImpl03", CircleDaoImpl03.class);
		Circle circle = dao.getCircle(2);
		System.out.println(circle);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
