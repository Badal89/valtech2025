package com.valtech.training.jars.services;

import java.util.List;

import com.valtech.training.jars.Movie;

public interface MovieService {

	List<Movie> getAlllMovies();

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}