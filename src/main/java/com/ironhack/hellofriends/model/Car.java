package com.ironhack.hellofriends.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String color;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private CarDriver driver;

    @OneToMany(mappedBy = "car")
    private List<TaxyOrder> taxyOrders;

    @ManyToMany
    @JoinTable(
            name = "car_customer",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers = new ArrayList<>();

    @Column(unique = true, nullable = false)
    private String licensePlate;


    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Car(String model, String color, String licensePlate, CarDriver driver) {
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.driver = driver;
    }

    public Car(String model, String color, String licensePlate) {
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public CarDriver getDriver() {
        return driver;
    }

    public void setDriver(CarDriver driver) {
        this.driver = driver;
    }

    public List<TaxyOrder> getTaxyOrders() {
        return taxyOrders;
    }

    public void setTaxyOrders(List<TaxyOrder> taxyOrders) {
        this.taxyOrders = taxyOrders;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", driver=" + driver +
                ", taxyOrders=" + taxyOrders +
                ", customers=" + customers +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
