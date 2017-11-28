package com.teja.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/third")
public interface IThirdController {

	@RequestMapping(method=RequestMethod.GET)
	public String third();
}
