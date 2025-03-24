package com.valtech.training.jaws.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.services.MovieService;


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
