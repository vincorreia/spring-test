package com.vincorreia.springtest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    @Autowired
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student vitor = new Student(
                    "Vitor",
                    "vitor.gomes@gmail.com",
                    LocalDate.of(2001, 1, 1)
            );
            Student maria = new Student(
                    "maria",
                    "maria.gomes@gmail.com",
                    LocalDate.of(1998, 1, 1)
            );

            repository.saveAll(
                    List.of(vitor, maria)
            );
        };
    }
}
