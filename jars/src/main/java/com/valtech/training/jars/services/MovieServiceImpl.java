package com.valtech.training.jars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.jars.Movie;
import com.valtech.training.jars.repos.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {
	
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public List<Movie> getAlllMovies(){
		return movieRepo.findAll();
	}
	
	@Override
	public Movie getMovie(long id) {
		return movieRepo.getReferenceById(id);
		
	}
	
	@Override
	public Movie createMovie(Movie m) {
		return movieRepo.save(m);
	}
	
	
	

}
