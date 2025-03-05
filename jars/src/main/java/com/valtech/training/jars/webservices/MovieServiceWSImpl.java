package com.valtech.training.jars.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.training.jars.Movie;
import com.valtech.training.jars.services.MovieService;


@WebService(endpointInterface ="com.valtech.training.jars.webservices.MovieServiceWS",
             name = "MovieService",portName = "MovieServicePort")
public class MovieServiceWSImpl implements MovieServiceWS {
	
	private MovieService movieservice;
	
	

	public MovieServiceWSImpl(MovieService movieservice) {
		this.movieservice = movieservice;
	}

	@Override
	public List<Movie> getAlllMovies() {
		return movieservice.getAlllMovies();
	}

	@Override
	public Movie getMovie(long id) {
		return movieservice.getMovie(id);
	}

	@Override
	public Movie createMovie(Movie m) {
		return movieservice.createMovie(m);
	}

}
