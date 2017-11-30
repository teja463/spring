package com.teja.spring.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ThirdController implements IThirdController {

	public String third() {
		return "third";
	}

	public String pathDemo(@PathVariable String key) {
		System.out.println("Got here.. "+key);
		return "third";
	}
	
}
