package com.teja.jpa.customjpa.controller;

import com.teja.jpa.customjpa.dto.StudentDTO;
import com.teja.jpa.customjpa.entity.Student;
import com.teja.jpa.customjpa.mapstruct.StudentMapper;
import com.teja.jpa.customjpa.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mapstruct")
public class MapStructController {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public MapStructController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = studentMapper.mapStudentsToDTO(students);
        return ResponseEntity.ok(studentDTOS);
    }
}
