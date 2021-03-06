package com.skilldistillery.movies.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.movies.entities.Movie;
import com.skilldistillery.movies.services.MovieService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4202"})
public class MovieController {
	
	@Autowired
	private MovieService movieServ;
	
	@GetMapping("movies")
	public List<Movie> allMovies(){
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
	
	@PostMapping("movies")
	public Movie addNewMovie(@RequestBody Movie movie, HttpServletResponse res) {
		try {
			Movie newMovie = movieServ.addNewMovie(movie);
			if(newMovie != null) {
				res.setStatus(201);
				return newMovie;
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return null;
	}
	
	@PutMapping("movies/{movieId}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer movieId) {
		Movie updatedMovie = movieServ.updateMovie(movie, movieId);
		return updatedMovie;
	}
	
	@DeleteMapping("movies/{movieId}")
	public void deleteMovie(@PathVariable Integer movieId, HttpServletResponse res) {
		try {
			movieServ.deleteMovie(movieId);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	@GetMapping("movies/search/{keyword}")
	public List<Movie> findMovieByKeyword(@PathVariable String keyword, HttpServletResponse res){
		List<Movie> result = movieServ.findMovieByKeyword(keyword);
		if(result == null) {
			res.setStatus(404);
		}
		
		return result;
	}
	
	@GetMapping("movies/search/{title}/{season}")
	public List<Movie> findMovieByTitleAndSeason(@PathVariable String title, @PathVariable Integer season, HttpServletResponse res){
		List<Movie> result = movieServ.findShowByTitleAndSeason(title, season);
		if(result == null) {
			res.setStatus(404);
		}
		return result;
	}

}
