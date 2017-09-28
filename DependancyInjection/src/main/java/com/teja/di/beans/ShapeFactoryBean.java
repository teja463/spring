package com.teja.di.beans;

public class ShapeFactoryBean {

	private static String shapeName;
	
	public static void setShapeName(String shapeName) {
		ShapeFactoryBean.shapeName = shapeName;
	}
	
	public Shape getShape() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (Shape)Class.forName(shapeName).newInstance();
	}
	
}
