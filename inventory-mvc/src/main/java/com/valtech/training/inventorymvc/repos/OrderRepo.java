package com.valtech.training.inventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.inventorymvc.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
