package com.redis.cache.service.impls;

import com.redis.cache.model.Student;
import com.redis.cache.model.StudentRedis;
import com.redis.cache.repository.StudentRepository;
import com.redis.cache.service.interfaces.StudentService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    public static final String KEY1 = "student::SimpleKey []";
    public static final String KEY2 = "student:SimpleKey []";
    public static final String KEY3 = "student:SimpleKey";
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
    @Cacheable(value = "student")
    public List<Student> findAll() {
        System.out.println("sem cache");
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public StudentRedis getById(Long id) {

//        Map<Object,Object> map = template.opsForHash().entries(KEY1);
//        var values = template.opsForHash().get(KEY1, id.toString());
        List<StudentRedis> studentRedis = template.opsForHash().values(KEY1);



//        values.forEach(System.out::println);

//        System.out.println(values);
//        System.out.println(map);

        var student = new StudentRedis();
        return student;
    }

}
