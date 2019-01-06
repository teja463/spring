package site.tejap.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle06 implements ApplicationContextAware, BeanNameAware{

	private String type;
	private String beanName;
	private ApplicationContext context;
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public String getBeanName() {
		return beanName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public void draw(){
		System.out.println("Drawing a "+ getType() + " tirangle. And the name of the bean defined in spring.xml is "+ getBeanName() +"  .");
		
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
