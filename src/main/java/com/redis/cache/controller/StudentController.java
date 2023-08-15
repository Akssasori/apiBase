package com.redis.cache.controller;

import com.redis.cache.dto.StudentRequestDTO;
import com.redis.cache.model.Student;
import com.redis.cache.service.interfaces.StudentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("student")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value= "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity createStudent(@RequestBody StudentRequestDTO studentRequestDTO) {

        var student = new Student();
        student.setEmail(studentRequestDTO.getEmail());
        student.setName(studentRequestDTO.getName());

        studentService.save(student);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping(value = "findAll")
    ResponseEntity findAll() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

}
