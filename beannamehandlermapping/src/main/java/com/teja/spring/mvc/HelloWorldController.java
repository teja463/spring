package com.teja.spring.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String name = req.getParameter("name");
		System.out.println("name: "+name);
		
		Map<String,String> map = new HashMap<>();
		map.put("name", name);
		ModelAndView modelAndView = new ModelAndView("success",map);
		return modelAndView;
	}

}
