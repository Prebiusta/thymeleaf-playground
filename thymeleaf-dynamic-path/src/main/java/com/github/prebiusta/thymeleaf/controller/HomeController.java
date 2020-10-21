package com.github.prebiusta.thymeleaf.controller;

import com.github.prebiusta.thymeleaf.model.Car;
import com.github.prebiusta.thymeleaf.model.Person;
import com.github.prebiusta.thymeleaf.repository.CarRepository;
import com.github.prebiusta.thymeleaf.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public HomeController(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    public String getMain(Model model){
        model.addAttribute("people", personRepository.findAll());
        return "web/index";
    }

    @GetMapping("/person/{personId}/cars")
    public String getCars(Model model, @PathVariable Long personId){
        model.addAttribute("cars", carRepository.findAllByPersonId(personId));
        model.addAttribute("person", personRepository.findById(personId));
        return "web/car-list";
    }

    @GetMapping("/person/create")
    public String createPerson(Model model){
        model.addAttribute("person", new Person());
        return "web/person/create";
    }

    @PostMapping("/person/create")
    public String addPerson(@ModelAttribute Person person){
        personRepository.save(person);
        return "redirect:/";
    }

    @GetMapping("/person/{personId}")
    public String editPerson(Model model, @PathVariable Long personId){
        model.addAttribute("person", personRepository.findById(personId));
        return "web/car-list";
    }

    @GetMapping("/person/{personId}/car")
    public String createCar(Model model, @PathVariable Long personId){
        model.addAttribute("person", personRepository.findById(personId));
        model.addAttribute("car", new Car());
        return "web/car-list";
    }

    @GetMapping("/person/{personId}/car/{carId}")
    public String editCar(Model model, @PathVariable Long personId, @PathVariable Long carId){
        model.addAttribute("person", carRepository.findById(carId));
        return "redirect:/person/" + personId;
    }

}
