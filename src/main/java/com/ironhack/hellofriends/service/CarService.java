package com.ironhack.hellofriends.service;

import com.ironhack.hellofriends.dto.UpdateCarColorRequest;
import com.ironhack.hellofriends.exception.ResourceNotFoundException;
import com.ironhack.hellofriends.model.Car;
import com.ironhack.hellofriends.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
    }

    public Car findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlateIgnoreCase(licensePlate)
                .orElseThrow(()-> new ResourceNotFoundException("Car not found with license plate: " + licensePlate));
    }

    public Car update(Long id, Car car) {
//        find the car by id
        var existingCar = carRepository.findById(id);
//        if we find id, we update the car and return it
        if (existingCar.isPresent()){
            Car carToUpdate = existingCar.get();
            carToUpdate.setModel(car.getModel());
            carToUpdate.setColor(car.getColor());
            carToUpdate.setLicensePlate(car.getLicensePlate());
            return carRepository.save(carToUpdate);
//        else we throw and exception
        } else {
            throw new ResourceNotFoundException("Car not found with id: " + id);
        }
    }


    public Car updateCarColor(UpdateCarColorRequest request){
        var carToUpdate = findById(request.getCarId());
        carToUpdate.setColor(request.getColor());
        return carRepository.save(carToUpdate);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
