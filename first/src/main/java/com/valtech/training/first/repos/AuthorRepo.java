package com.valtech.training.first.repos;



import com.valtech.training.first.entities.Author;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
	  List<Author> findAll();
    
}

