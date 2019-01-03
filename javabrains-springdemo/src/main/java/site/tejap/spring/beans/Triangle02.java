package site.tejap.spring.beans;

public class Triangle02 {

	private String type;
	private int height;
	
	public Triangle02(String type, int height) {
		System.out.println("Creating triangle object using parameterized constructor");
		this.type = type;
		this.height = height;
	}

	public void draw() {
		System.out.println("Drawing a " + type + " triangle of height " +height);
	}
}
