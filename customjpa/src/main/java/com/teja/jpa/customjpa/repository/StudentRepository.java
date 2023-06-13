package com.teja.jpa.customjpa.repository;

import com.teja.jpa.customjpa.dto.StudentDTO;
import com.teja.jpa.customjpa.dto.StudentInterface;
import com.teja.jpa.customjpa.dto.StudentRecord;
import com.teja.jpa.customjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select new com.teja.jpa.customjpa.entity.Student(s.id, s.firstName,s.email) from Student s")
    public List<Student> getStudentCustomFields();

    @Query(value = "select s.id, s.first_name as firstName, s.email from student s", nativeQuery = true)
    public List<StudentInterface> getStudentNativeInterface();

    @Query(value = "select * from student", nativeQuery = true)
    public List<Student> getStudentNativeAll();

    @Query("select new com.teja.jpa.customjpa.dto.StudentRecord(s.id, s.firstName,s.totalMarks) from Student s")
    public List<StudentRecord> getStudentRecord();

    @Query("select new com.teja.jpa.customjpa.dto.StudentDTO(s.id, s.firstName, s.email) from Student s")
    public List<StudentDTO> getStudentDTO();
}
