package com.redis.cache.service.interfaces;

import com.redis.cache.model.Student;
import com.redis.cache.model.StudentRedis;

import java.util.List;

public interface StudentService {

    Student save(Student student);

    List<Student> findAll();

    StudentRedis getById(Long id);


}
