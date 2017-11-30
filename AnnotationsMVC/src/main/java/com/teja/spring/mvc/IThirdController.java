package com.teja.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/third")
public interface IThirdController {

	@RequestMapping(method=RequestMethod.GET)
	public String third();
	
	@RequestMapping("/key/{key}")
	public String pathDemo(@PathVariable String key);
}
