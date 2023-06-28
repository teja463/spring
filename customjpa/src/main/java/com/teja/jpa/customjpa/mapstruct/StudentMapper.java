package com.teja.jpa.customjpa.mapstruct;

import com.teja.jpa.customjpa.dto.StudentDTO;
import com.teja.jpa.customjpa.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "id", target = "studentId")
    StudentDTO mapStudentToDTO(Student student);

    List<StudentDTO> mapStudentsToDTO(List<Student> student);
}
