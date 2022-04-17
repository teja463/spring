package com.practice.minutes.microservices.controller;

import com.practice.minutes.microservices.domain.User;
import com.practice.minutes.microservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable Integer id) {

        User userById = userDaoService.getUserById(id);
        EntityModel userModel = EntityModel.of(userById);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers()).withRel("all-users");
        userModel.add(link);
        return userModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) throws BindException {
//        System.out.println(bindingResult.getErrorCount());
//        bindingResult.getAllErrors().stream().forEach(err -> {
//            System.out.println(err.getDefaultMessage());
//        });
//        if(bindingResult.hasErrors()){
//            throw new BindException(bindingResult);
//        }
        User user1 = userDaoService.saveUser(user);
        ResponseEntity<User> userResponseEntity = new ResponseEntity<>(user1, HttpStatus.CREATED);
        return userResponseEntity;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDaoService.deleteUser(id);
    }
}
