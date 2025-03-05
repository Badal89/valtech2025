package com.valtech.training.jars.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.jars.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

}
