package site.tejap.spring.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.tejap.spring.dao.CircleDaoImpl05;
import site.tejap.spring.dto.Circle;

public class SpringData05RowMapperAndUpdateQuery {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring05.xml");
		CircleDaoImpl05 dao = context.getBean("circleDaoImpl05", CircleDaoImpl05.class);
		
		Circle circle = dao.getCircle(1);
		System.out.println(circle);
		
		List<Circle> allCircles = dao.getAllCircles();
		System.out.println(allCircles.size());
		
		int inserCircle = dao.inserCircle(new Circle(7,90));
		System.out.println(inserCircle);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
