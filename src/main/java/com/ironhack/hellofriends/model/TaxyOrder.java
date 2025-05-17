package com.ironhack.hellofriends.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class TaxyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String origin;
    private String destination;

    @ManyToOne
    private Car car;



    public TaxyOrder(String origin, String destination, Car car) {
        this.origin = origin;
        this.destination = destination;
        this.car = car;
    }

    public TaxyOrder() {
    }

    @Override
    public String toString() {
        return "TaxyOrder{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
