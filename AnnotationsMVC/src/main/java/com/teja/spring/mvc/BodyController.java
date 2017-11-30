package com.teja.spring.mvc;

import java.io.IOException;
import java.io.Writer;

import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * {@code @RequestBody} represents the http body. When you submit the form or do any action the whole http body will be represented by RequestBody.
 * There are few converters {@link HttpMessageConverter} classes like {@link StringHttpMessageConverter} {@link ByteArrayHttpMessageConverter} 
 * which will convert the http body in to a string or byte array form of RequestBody.
 * </p></p>
 * {@code @ResponseBody} when you want to write something directly to the http response. In below method if you annoate the method with 
 * {@code @ResponseBody} {@link Controller} it will not convert into index.jsp. In this way you write anything directly to http response.
 * This will be usefull if you want to write any JSON, XML data or any other data. {@code RestController} will be using this method to write JSON, XML
 * or any other data to response. 
 * </p> 
 * @author BPonnuru
 */
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
