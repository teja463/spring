package site.tejap.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class Triangle14 implements ApplicationEventPublisherAware{

	private Point pointA;
	
	private ApplicationEventPublisher applicationEventPublisher;

	public Point getPointA() {
		return pointA;
	}

	@Autowired
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	
	public void draw() {
		System.out.println("Drawing a triangle at points ( " +getPointA().getX() + ", " + getPointA().getY() +" )");
		DrawEvent event = new DrawEvent(this);
		applicationEventPublisher.publishEvent(event);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

}
