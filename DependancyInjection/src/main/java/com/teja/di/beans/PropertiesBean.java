package com.teja.di.beans;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesBean {

	private Properties db;
	
	public void setDb(Properties db) {
		this.db = db;
	}
	
	public void printDBDetails(){
		Set<Object> keySet = db.keySet();
		Iterator<Object> iterator = keySet.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			System.out.println("Key: "+obj.toString()+ " Value: "+db.getProperty(obj.toString()));
		}
	}
}
