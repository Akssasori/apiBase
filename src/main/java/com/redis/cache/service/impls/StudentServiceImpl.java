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

    private final RedisTemplate template;

    public StudentServiceImpl(StudentRepository studentRepository, RedisTemplate template) {
        this.studentRepository = studentRepository;
        this.template = template;
    }

    @Override
    @CacheEvict(cacheNames = "student", allEntries = true)
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Cacheable(value = "findAll")
    public List<Student> findAll() {
        System.out.println("sem cache");
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        var value = template.opsForHash().values("findAll::SimpleKey []");
        System.out.println(value);
        return (Student) value;
    }

}
