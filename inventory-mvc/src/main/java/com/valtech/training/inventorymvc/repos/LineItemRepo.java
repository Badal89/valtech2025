package com.valtech.training.inventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.inventorymvc.entities.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {

}
