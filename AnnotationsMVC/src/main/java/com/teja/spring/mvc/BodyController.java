package com.teja.spring.mvc;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/body")
public class BodyController {

	@RequestMapping("/request")
	public void reqBody(@RequestBody String reqBody, Writer writer){
		try {
			System.out.println("reqBody:"+reqBody);
			writer.write("reqBody:"+reqBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/response")
	public @ResponseBody String resBody(){
		return "index";
	}
}
