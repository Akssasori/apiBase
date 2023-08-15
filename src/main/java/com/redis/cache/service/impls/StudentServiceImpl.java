package com.redis.cache.service.impls;

import com.redis.cache.model.Student;
import com.redis.cache.repository.StudentRepository;
import com.redis.cache.service.interfaces.StudentService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @CacheEvict(cacheNames = "student", allEntries = true)
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Cacheable(value = "student")
    public List<Student> findAll() {
        System.out.println("sem cache");
        return (List<Student>) studentRepository.findAll();
    }


}
