package site.tejap.spring.beans;

import org.springframework.beans.factory.annotation.Required;

public class Triangle10{
	
	private Point pointA;

		
	public Point getPointA() {
		return pointA;
	}

	@Required
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}


	public void draw(){
		System.out.println("Drawing a triangle at points ( " +getPointA().getX() + " " + getPointA().getY() +" )");
	}
}
