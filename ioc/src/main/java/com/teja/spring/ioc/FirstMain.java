package com.teja.spring.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.teja.spring.ioc.beans.Puma;
import com.teja.spring.ioc.beans.Shoe;
import com.teja.spring.ioc.config.AppConfig;

public class FirstMain {

	private static final Log logger = LogFactory.getLog(FirstMain.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annCtx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Shoe shoe1 = annCtx.getBean("shoe2",Shoe.class);
		System.out.println("SHoe1: "+shoe1);
		
		Shoe shoe2 = annCtx.getBean("shoe2",Shoe.class);
		System.out.println("SHoe2: "+shoe2);
		
		Shoe pumaShoe = annCtx.getBean("pumaShoe",Puma.class);
		System.out.println(pumaShoe);
		
		ShowRoom showRoom = annCtx.getBean("showRoom",ShowRoom.class);
		ShowRoom showRoom2 = annCtx.getBean("showRoom",ShowRoom.class);
		System.out.println(showRoom.puma);
		System.out.println(showRoom2.puma);
		showRoom.puma.wear();
		showRoom.shoe.wear();
		annCtx.close();
	}
}
