package site.tejap.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Triangle11{
	
	
	private Point pointA;

	private Point pointB;
	
	
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
	@Qualifier("pointB")
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void draw(){
		System.out.println("Drawing a triangle at points ( " +getPointA().getX() + ", " + getPointA().getY() +" )");
		System.out.println("Drawing a triangle at points ( " +getPointB().getX() + ", " + getPointB().getY() +" )");
	}
}
