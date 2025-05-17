package com.ironhack.hellofriends.model;


import jakarta.persistence.*;

@Entity
public class CarDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToOne(mappedBy = "driver")
//    private Car car;


    public CarDriver(String name) {
        this.name = name;
    }

    public CarDriver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
