package com.teja.di.beans;

public class DefaultCollectionBean {

	private String [] names;
	private Engine [] engines;
	
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	
	public void setEngines(Engine[] engines) {
		this.engines = engines;
	}
	
	
	public void printData(){
		
		for(String name : names){
			System.out.println("Name: "+name);
		}
		
		for(Engine engine : engines){
			System.out.println(engine.getModelYear());
		}
	}
}
