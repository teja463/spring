package site.tejap.spring.beans;

public class Triangle01 {

	public Triangle01(){
		System.out.println("Creating triangle object");
	}
	
	private String type;


	public void setType(String type) {
		System.out.println("Setting the triangle type");
		this.type = type;
	}

	public void draw() {
		System.out.println("Drawing a " + type + " triangle.");
	}
}
