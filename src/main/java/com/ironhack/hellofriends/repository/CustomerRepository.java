package com.ironhack.hellofriends.repository;

import com.ironhack.hellofriends.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
