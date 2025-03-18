package com.valtech.training.inventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.inventorymvc.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
