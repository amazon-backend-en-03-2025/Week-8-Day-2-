package com.ironhack.hellofriends.repository;

import com.ironhack.hellofriends.model.Car;
import com.ironhack.hellofriends.model.TaxyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaxyOrderRepository extends JpaRepository<TaxyOrder, UUID> {

    List<TaxyOrder> findByCar_ColorIgnoreCase(String color);

//    List<Car> findByCar_Driver_NameIgnoreCase(String name);
}
