package com.redis.cache.repositories;

import com.redis.cache.model.Student;
import com.redis.cache.repository.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Testcontainers // Anotação para habilitar o suporte do Testcontainers
class StudentRepositoryTest {

    // Configurando o MySQLContainer
    @Container
    private static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testjpa")
            .withUsername("root")
            .withPassword("coti");

    @Autowired
    private StudentRepository studentRepository;


    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
    }

    @BeforeAll
    static void setUp() {
        mysqlContainer.start(); // Inicia o container
    }

    @AfterAll
    static void tearDown() {
        mysqlContainer.stop(); // Para o container
    }

    @Test
    void testSaveAndFind() {

        Student entity = new Student();
        entity.setEmail("lucas@gmail.com");
        entity.setName("Lucas");

        studentRepository.save(entity);

        Student foundEntity = studentRepository.findById(entity.getId()).orElse(null);

        assertThat(foundEntity).isNotNull();
        assertThat(foundEntity.getName()).isEqualTo("Lucas");
    }
}
