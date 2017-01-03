package com.teja.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.teja.spring.ioc.beans.Puma;
import com.teja.spring.ioc.beans.Shoe;

public class ShowRoom {

	@Autowired
	@Qualifier(value="pumaShoe")
	public Puma puma;
	
	@Autowired
	@Qualifier(value="shoe")
	public Shoe shoe;
}
