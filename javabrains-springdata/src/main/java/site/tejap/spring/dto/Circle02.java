package site.tejap.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="circle")
public class Circle02 {

	@Id
	private int id;
	
	private int radius;

	public Circle02(int id, int radius) {
		super();
		this.id = id;
		this.radius = radius;
	}
	
	public Circle02(){
		
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
