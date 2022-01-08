package com.skilldistillery.movies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.movies.entities.Snack;

public interface SnackRepository extends JpaRepository<Snack, Integer> {
	
	List<Snack> findByNameLike(String keyword);

}
