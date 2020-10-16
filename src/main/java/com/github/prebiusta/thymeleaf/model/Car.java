package com.github.prebiusta.thymeleaf.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Double engineVolume;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Car() {
    }

    public Car(Long id, String name, Double engineVolume, Double price, Person person) {
        this.id = id;
        this.name = name;
        this.engineVolume = engineVolume;
        this.price = price;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public Double getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engineVolume=" + engineVolume +
                ", price=" + price +
                ", person=" + person +
                '}';
    }
}
