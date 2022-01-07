package com.skilldistillery.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.movies.entities.Movie;
import com.skilldistillery.movies.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	
	

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Movie getById() {
		return movieRepo.getById(null);
	}

}
