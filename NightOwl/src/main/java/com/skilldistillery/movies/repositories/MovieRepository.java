package com.skilldistillery.movies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.movies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	

}
