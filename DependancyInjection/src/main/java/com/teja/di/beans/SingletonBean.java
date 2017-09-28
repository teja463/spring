package com.teja.di.beans;

public class SingletonBean {

	private static SingletonBean sb;
	
	private SingletonBean(){
		
	}
	
	public static SingletonBean getInstance(){
		System.out.println("creating bean with this method");
		if(null==sb){
			System.out.println("creating a new instance");
			sb = new SingletonBean();
		}else{
			System.out.println("Returning already existing instance");
		}
		
		return sb;
	}

	public void printData(){
		System.out.println("This is a singleton class example");
	}
}
