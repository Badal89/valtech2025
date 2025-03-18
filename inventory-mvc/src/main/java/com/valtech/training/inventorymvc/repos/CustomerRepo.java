package com.valtech.training.inventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.inventorymvc.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
