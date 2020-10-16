package com.github.prebiusta.thymeleaf.controller;

import com.github.prebiusta.thymeleaf.repository.CarRepository;
import com.github.prebiusta.thymeleaf.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public HomeController(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @GetMapping
    public String getMain(Model model){
        model.addAttribute("people", personRepository.findAll());
        return "web/index";
    }

    @GetMapping("/person/{personId}/cars")
    public String getCars(Model model, @PathVariable Integer personId){
        model.addAttribute("cars", carRepository.findAllByPersonId(personId));
        return "web/car-list";
    }


}
