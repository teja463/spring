package com.example.springboooth2jpaexample.controller;

import com.example.springboooth2jpaexample.domain.Item;
import com.example.springboooth2jpaexample.domain.User;
import com.example.springboooth2jpaexample.repo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/addItem/{id}")
    public ResponseEntity<Object> addItem(@RequestParam String item, @PathVariable Long id) {
        Item in = new Item(item);
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.getItems().clear();
        user.getItems().add(in);
//        user.addItem(in);
        User savedUser = userRepository.save(user);
        return ResponseEntity.created(null).body(savedUser);
    }

    @GetMapping("/deleteItem/{id}")
    public ResponseEntity<Object> deleteItem(@RequestParam String item, @PathVariable Long id) {
        Item in = new Item(item);
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        int last = user.getItems().size() - 1;
        user.getItems().remove(last);
        User savedUser = userRepository.save(user);
        return ResponseEntity.created(null).body(savedUser);
    }


}
