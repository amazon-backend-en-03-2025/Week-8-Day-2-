package com.ironhack.hellofriends.demo;


import com.ironhack.hellofriends.model.Car;
import com.ironhack.hellofriends.model.CarDriver;
import com.ironhack.hellofriends.model.Customer;
import com.ironhack.hellofriends.model.TaxyOrder;
import com.ironhack.hellofriends.repository.CarDriverRepository;
import com.ironhack.hellofriends.repository.CarRepository;
import com.ironhack.hellofriends.repository.CustomerRepository;
import com.ironhack.hellofriends.repository.TaxyOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final CarDriverRepository carDriverRepository;
    private final TaxyOrderRepository taxyOrderRepository;
    private final CustomerRepository customerRepository;

    public DataLoader(CarRepository carRepository, CarDriverRepository carDriverRepository, TaxyOrderRepository taxyOrderRepository, CustomerRepository customerRepository) {
        this.carRepository = carRepository;
        this.carDriverRepository = carDriverRepository;
        this.taxyOrderRepository = taxyOrderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data...");

        var carDriver1 = new CarDriver("Jason ");
        var carDriver2 = new CarDriver("Martha");

        carDriverRepository.saveAll(List.of(carDriver1, carDriver2));


        var car1 = new Car("RAM", "Black", "B4DB0NN7", carDriver1);
        var car2 = new Car("BMW", "White", "P1N4C0L4DA", carDriver2);

        carRepository.saveAll(List.of(car1, car2));



//        HERE U SEE HOW TO ADD A CAR DRIVER TO A CAR AFTER THE CAR IS CREATED
        var driver3 = new CarDriver("John");
        carDriverRepository.save(driver3);
        var car3 = new Car("Toyota", "Red", "C4R3N0T4");
        carRepository.save(car3);
        System.out.println("Car 3 saved: " + car3);

        car3.setDriver(driver3);
        carRepository.save(car3);
        System.out.println("Car 3 updated with driver: " + car3);

        var taxyOrder1 = new TaxyOrder("Ferry station",
                "Esperanza",
                car1);

        taxyOrderRepository.save(taxyOrder1);

        System.out.println(taxyOrder1);
//        System.out.println(car1.getTaxyOrders());
        System.out.println("Data loaded!");

        System.out.println("Find all taxy order by color of the car:");
        var list = taxyOrderRepository.findByCar_ColorIgnoreCase("Yellow");


        System.out.println(list);


        System.out.println("printing the car with the customer");
        var customer1 = new Customer("John");
        var customer2 = new Customer("Mary");
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        car1.addCustomer(customer1);
        car1.addCustomer(customer2);
        carRepository.save(car1);
        System.out.println(car1);
    }
}
