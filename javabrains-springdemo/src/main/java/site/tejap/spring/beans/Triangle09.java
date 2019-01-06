package site.tejap.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle09 implements InitializingBean, DisposableBean{
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void draw(){
		System.out.println("Drawing a " + type + " triangle.");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("IntializingBean afterPropertiesSet");
	}
	
	public void init(){
		System.out.println("init");
	}
	
	public void myDestroy(){
		System.out.println("destroy");
	}
}
