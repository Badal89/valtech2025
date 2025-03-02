package com.valtech.training.first.repos;



import com.valtech.training.first.entities.Publisher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    
	 List<Publisher> findAll(); 
}

