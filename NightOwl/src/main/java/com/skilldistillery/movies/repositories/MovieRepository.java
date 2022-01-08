package com.skilldistillery.movies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.movies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	List<Movie> findByTitleLike(String keyword);

}
