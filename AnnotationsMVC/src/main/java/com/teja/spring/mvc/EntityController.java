package com.teja.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * {@link HttpEntity} is another way to get the {@link RequestBody} of the {@link HttpServletRequest}. It is more convenient to use as it has methods to 
 * get the body, get the headers. 
 * 
 * {@link ResponseEntity} is sub class for HttpEntity which is used to wirte response to the http output stream. 
 * </p>
 * @author BPonnuru
 */
@Controller
@RequestMapping("/entity")
public class EntityController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<String> entityDemo(HttpEntity<byte []> httpEntity){
		byte[] httpBody = httpEntity.getBody();
		System.out.println("reqBody: "+new String(httpBody));
		HttpHeaders headers = httpEntity.getHeaders();
		String header = headers.getFirst("MyHeader");
		return new ResponseEntity<String>(header,HttpStatus.CREATED);
	}
}
