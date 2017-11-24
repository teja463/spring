package com.teja.di.beans;

public class PropertyPlaceHolderBean {

	private String driverName;
	private String url;
	private String username;
	private String password;
	
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void createConnection(){
		System.out.printf("Creating connection for %s on host: %s using username: %s and password: %s", driverName, url, username, password);
	}
	
}
