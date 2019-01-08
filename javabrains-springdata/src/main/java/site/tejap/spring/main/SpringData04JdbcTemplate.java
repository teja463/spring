package site.tejap.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.dao.CircleDaoImpl04;
import site.tejap.spring.dto.Circle;

public class SpringData04JdbcTemplate {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring04.xml");
		CircleDaoImpl04 dao = context.getBean("circleDaoImpl04", CircleDaoImpl04.class);
		int count = dao.getCircleCount();
		System.out.println(count);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
