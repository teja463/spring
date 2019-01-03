package site.tejap.spring.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import site.tejap.spring.beans.Triangle;

public class Spring01XmlBeanFactoryDemo {

	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring01.xml"));
		
		Triangle bean = (Triangle) factory.getBean("triangle");
		bean.draw();
	}
}
