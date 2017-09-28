package com.teja.di.beans;

import org.springframework.beans.factory.FactoryBean;

public class ShapeFactory implements FactoryBean{

	private String shapeName;
	
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	
	public Object getObject() throws Exception {
		return (Shape)Class.forName(shapeName).newInstance();
	}

	public Class getObjectType() {
		return Shape.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
