package com.github.prebiusta.thymeleaf.repository;

import com.github.prebiusta.thymeleaf.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAll();
    Person findById(long id);
}
