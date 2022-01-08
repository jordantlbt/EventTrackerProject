package com.skilldistillery.movies.services;

import java.util.List;

import com.skilldistillery.movies.entities.Snack;

public interface SnackService {
	
	List<Snack> getAllSnacks();
	Snack getById(int snackId);
	Snack addNewSnack(Snack snack);
	Snack updateSnack(Snack snack, int snackId);
	boolean deleteMovie(int snackId);
	List<Snack> findSnackByKeyword(String keyword);

}
