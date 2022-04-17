package com.practice.minutes.microservices.haetos;

import com.practice.minutes.microservices.domain.User;
import com.practice.minutes.microservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/haetos")
public class HaetosController {

    @Autowired
    UserDaoService userDaoService;

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
}
