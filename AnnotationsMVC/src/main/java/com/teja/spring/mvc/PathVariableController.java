package com.teja.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path/{name}")
public class PathVariableController {

	@RequestMapping("/email/{mailId}")
	public String demo(@PathVariable String name, @PathVariable String mailId) {
		System.out.println("Name: " + name);
		System.out.println("Email: " + mailId);
		return "path";
	}
	
	@RequestMapping("/${test.url.path}")
	public String placeHolderDemo(){
		return "index";
	}
	
	@RequestMapping("/matrix/{type}")
	public String matrixDemo(@PathVariable String type, @MatrixVariable String colors){
		return "matrix";
	}
}
