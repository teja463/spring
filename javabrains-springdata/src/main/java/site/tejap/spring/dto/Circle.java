package site.tejap.spring.dto;

public class Circle {

	private int id;
	
	private int radius;

	public Circle(int id, int radius) {
		super();
		this.id = id;
		this.radius = radius;
	}
	
	public Circle(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [id=" + id + ", radius=" + radius + "]";
	}

	
	
}
