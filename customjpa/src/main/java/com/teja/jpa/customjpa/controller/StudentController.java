package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.dto.StudentDTO;
import com.teja.jpa.customjpa.dto.StudentInterface;
import com.teja.jpa.customjpa.dto.StudentRecord;
import com.teja.jpa.customjpa.entity.Student;
import com.teja.jpa.customjpa.exception.StudentNotFound;
import com.teja.jpa.customjpa.repository.StudentRepository;
import com.teja.jpa.customjpa.util.BindingResultUtil;
import com.teja.jpa.customjpa.validation.StudentValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentRepository studentRepository;
    private StudentValidator studentValidator;

    public StudentController(StudentRepository studentRepository, StudentValidator studentValidator) {
        this.studentRepository = studentRepository;
        this.studentValidator = studentValidator;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/customfields")
    public ResponseEntity<List<Student>> getCustomStudents(){
        return ResponseEntity.ok(studentRepository.getStudentCustomFields());
    }

    @GetMapping("/interface")
    public ResponseEntity<List<StudentInterface>> getStudents_Interface(){
        return ResponseEntity.ok(studentRepository.getStudentInterface());
    }

    @GetMapping("/dto")
    public ResponseEntity<List<StudentDTO>> getStudents_DTO(){
        return ResponseEntity.ok(studentRepository.getStudentDTO());
    }

    @GetMapping("/record")
    public ResponseEntity<List<StudentRecord>> getStudents_Record(){
        return ResponseEntity.ok(studentRepository.getStudentRecord());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with Id "+id));
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student, BindingResult bindingResult){
        studentValidator.validate(student, bindingResult);
        if(bindingResult.hasErrors()){
            List<String> list = BindingResultUtil.constructErrors(bindingResult);
            throw new StudentNotFound(list.toString());
        }
        return ResponseEntity.created(null).body(studentRepository.save(student));
    }

    @PostMapping(headers = {"version=v2"})
    public ResponseEntity<Student> addStudentV2(@RequestBody @Valid Student student){
        return ResponseEntity.created(null).body(studentRepository.save(student));
    }
}
