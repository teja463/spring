package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.dto.StudentDTO;
import com.teja.jpa.customjpa.dto.StudentInterface;
import com.teja.jpa.customjpa.dto.StudentRecord;
import com.teja.jpa.customjpa.entity.Student;
import com.teja.jpa.customjpa.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class AllQueriesController {

    private StudentRepository studentRepository;

    public AllQueriesController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/customfields")
    public ResponseEntity<List<Student>> getCustomStudents() {
        return ResponseEntity.ok(studentRepository.getStudentCustomFields());
    }

    @GetMapping("/native-interface")
    public ResponseEntity<List<StudentInterface>> getStudentsInterface() {
        return ResponseEntity.ok(studentRepository.getStudentNativeInterface());
    }

    @GetMapping("/native-all")
    public ResponseEntity<List<Student>> getStudentsNativeAll() {
        return ResponseEntity.ok(studentRepository.getStudentNativeAll());
    }

    @GetMapping("/native-mapping")
    public ResponseEntity<List<StudentDTO>> getStudentsNativeMapping() {
        return null;
    }

    @GetMapping("/dto")
    public ResponseEntity<List<StudentDTO>> getStudentsDTO() {
        return ResponseEntity.ok(studentRepository.getStudentDTO());
    }

    @GetMapping("/record")
    public ResponseEntity<List<StudentRecord>> getStudentsRecord() {
        return ResponseEntity.ok(studentRepository.getStudentRecord());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with Id " + id));
        return ResponseEntity.ok(student);
    }


}
