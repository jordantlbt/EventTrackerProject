package com.skilldistillery.movies.services;

import java.util.List;

import com.skilldistillery.movies.entities.Movie;



public interface MovieService {
	
	List<Movie> getAllMovies();
	Movie getById();
//	Movie addNewMovie();
//	Movie updateMovie();
//	Movie deleteMovie();

}
