package com.teja.redis_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/add")
    public Student add(@RequestBody Student student){
        student.setId(UUID.randomUUID().toString());
        studentRepo.save(student);
        return student;
    }

    @GetMapping
    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        studentRepo.findAll().forEach(students::add);
        return students;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable String id){
        return studentRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
