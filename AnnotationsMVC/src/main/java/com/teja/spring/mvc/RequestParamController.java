package com.teja.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * By default all the request paramets are mandatory. You can change them to optional by using {@code required=false}
 * If you dont make this change then if you hit /request it will give 400 or 404 error because it will not match the path.
 * </p>
 * @author BPonnuru
 *
 */
@Controller
@RequestMapping("/request")
public class RequestParamController {

	/**
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String paramDemo(@RequestParam(value="name", required=false) String name, @RequestParam(value="email", required=false) String email, Model model){
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		System.out.printf("Name: %s Email: %s", name , email);
		return "requestParam";
	}
}
