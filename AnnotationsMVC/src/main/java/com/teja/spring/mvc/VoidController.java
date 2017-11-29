package com.teja.spring.mvc;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/void")
public class VoidController {

	@RequestMapping(method=RequestMethod.GET)
	public void voidDemo(PrintWriter writer, WebRequest request, HttpServletResponse response){
		response.setContentType("application/json");
		String name = request.getParameter("name");
		System.out.println("Name: "+name);
		writer.print("{name:\""+name+"\"}");
	}
}
