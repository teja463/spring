package com.practice.minutes.microservices.controller;

import com.practice.minutes.microservices.domain.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld(){
        String hello = messageSource.getMessage("hello", null, LocaleContextHolder.getLocale());
        return hello;
    }

    @GetMapping(value = "/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello World Bean");
    }
}
