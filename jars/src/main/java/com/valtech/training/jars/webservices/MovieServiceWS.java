package com.valtech.training.jars.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.training.jars.Movie;


@WebService
public interface MovieServiceWS {

	List<Movie> getAlllMovies();

	Movie getMovie(long id);

	Movie createMovie(Movie m);

}