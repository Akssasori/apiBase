package com.redis.cache.controller;

import com.redis.cache.dto.StudentRequestDTO;
import com.redis.cache.model.Student;
import com.redis.cache.repository.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("student")
@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping(value= "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {

        var student = new Student();
        student.setEmail(studentRequestDTO.getEmail());
        student.setName(studentRequestDTO.getName());

        studentRepository.save(student);

        return ResponseEntity.ok().body(student);
    }
}
