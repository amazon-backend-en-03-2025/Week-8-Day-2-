package com.ironhack.hellofriends.demo;


import com.ironhack.hellofriends.model.Car;
import com.ironhack.hellofriends.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataLoader(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Loading data...");
        var car1 = new Car("RAM", "Black", "B4DB0NN7");
        var car2 = new Car("BMW", "White", "P1N4C0L4DA");

        carRepository.saveAll(List.of(car1, car2));

        System.out.println("Data loaded!");

    }
}
