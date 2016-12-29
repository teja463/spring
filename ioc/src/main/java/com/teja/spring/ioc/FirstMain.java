package com.teja.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.teja.spring.ioc.beans.Puma;
import com.teja.spring.ioc.beans.Shoe;
import com.teja.spring.ioc.config.AppConfig;

public class FirstMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annCtx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Shoe shoe = annCtx.getBean("shoe",Shoe.class);
		shoe.wear();
		
		Shoe pumaShoe = annCtx.getBean("pumaShoe",Puma.class);
		pumaShoe.wear();
		
		annCtx.close();
	}
}
