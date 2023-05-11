package com.redis.cache.service.interfaces;

import com.redis.cache.model.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> findAll();
}
