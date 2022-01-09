package com.skilldistillery.movies.services;

import java.util.List;

import com.skilldistillery.movies.entities.Movie;



public interface MovieService {
	
	List<Movie> getAllMovies();
	Movie getById(int movieId);
	Movie addNewMovie(Movie movie);
	Movie updateMovie(Movie movie, int movieId);
	boolean deleteMovie(int movieId);
	List<Movie> findMovieByKeyword(String keyword);
	List<Movie> findShowByTitleAndSeason(String title, int season);

}
