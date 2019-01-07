package site.tejap.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Triangle13 {

	private MessageSource messageSource;

	private Point pointA;

	private Point pointB;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getPointA() {
		return pointA;
	}

	@Autowired
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	@Autowired
	@Resource(name = "secondPoint")
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}


	@PostConstruct
	public void init(){
		System.out.println("after properties set");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Before bean destroy");
	}
	
	public void draw() {
		System.out.println(messageSource.getMessage("triangle.drawing.points", new Object[]{getPointA().getX(), getPointA().getY()}, null));
		System.out.println(messageSource.getMessage("triangle.drawing.points", new Object[]{getPointB().getX(), getPointB().getY()}, null));
	}
}
