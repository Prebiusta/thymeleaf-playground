package com.github.prebiusta.thymeleaf.controller;

import com.github.prebiusta.thymeleaf.model.Car;
import com.github.prebiusta.thymeleaf.model.Person;
import com.github.prebiusta.thymeleaf.repository.CarRepository;
import com.github.prebiusta.thymeleaf.repository.PersonRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public DataLoader(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }


    public void run(ApplicationArguments args) {
        initApp();
    }

    private void initApp() {
            Person person = personRepository.save(new Person(1L, "Name", "Last Name"));
            for (int carCount = 0; carCount < 10; carCount++) {
                Car car = new Car(
                        (long)carCount,
                        "Name " + carCount,
                        (double)carCount,
                        (double)carCount,
                        person
                );
                carRepository.save(car);
            }

    }
}
