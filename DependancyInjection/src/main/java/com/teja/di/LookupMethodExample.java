package com.teja.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.teja.di.beans.AbstractBus;
import com.teja.di.beans.ICar;
import com.teja.di.beans.Truck;

public class LookupMethodExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/lookupMethod.xml");
		ICar car = context.getBean("c", com.teja.di.beans.ICar.class);
		
		System.out.println(car.getEngine().getModelYear());
		
		AbstractBus bus = context.getBean("b", com.teja.di.beans.AbstractBus.class);
		System.out.println(bus.getEngine().getModelYear());
		
		Truck truck = context.getBean("t", com.teja.di.beans.Truck.class);
		System.out.println(truck.getEngine().getModelYear());
	}
}
