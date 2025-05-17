package com.ironhack.hellofriends.controller;

import com.ironhack.hellofriends.dto.UpdateCarColorRequest;
import com.ironhack.hellofriends.model.Car;
import com.ironhack.hellofriends.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car) {
        return carService.create(car);
    }

    @GetMapping
    public List<Car> findAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @GetMapping("/license-plate/{licensePlate}")
    public Car findCarByLicensePlate(@PathVariable String licensePlate) {
        return carService.findByLicensePlate(licensePlate);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.update(id, car);
    }

    @PatchMapping("/color")
    public Car updateCarColor(@RequestBody UpdateCarColorRequest request){
        return carService.updateCarColor(request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }
}
