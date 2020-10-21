package com.github.prebiusta.thymeleaf.repository;

import com.github.prebiusta.thymeleaf.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByPersonId(long id);
    Car findById(long id);
}
