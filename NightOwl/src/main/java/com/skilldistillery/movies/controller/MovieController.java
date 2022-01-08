package com.skilldistillery.movies.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.movies.entities.Movie;
import com.skilldistillery.movies.services.MovieService;

@RestController
@RequestMapping("api")
public class MovieController {
	
	@Autowired
	private MovieService movieServ;
	
	@GetMapping("movies")
	public List<Movie> index(){
		return movieServ.getAllMovies();
	}
	
	@GetMapping("movies/{movieId}")
	public Movie findMovieById(@PathVariable Integer movieId, HttpServletResponse res) {
		Movie movie = movieServ.getById(movieId);
		if(movie == null) {
			res.setStatus(404);
		}
		return movie;
	}

}
