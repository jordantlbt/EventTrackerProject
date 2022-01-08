package com.skilldistillery.movies.services;

import java.util.List;
import java.util.Optional;

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
	public Movie getById(int movieId) {
		Optional<Movie> op = movieRepo.findById(movieId);
		if(op.isPresent()) {
			return op.get();
		}
		
		return null;
	}

	@Override
	public Movie addNewMovie(Movie movie) {
		Movie newMovie = movieRepo.save(movie);
		return newMovie;
	}

	@Override
	public Movie updateMovie(Movie movie, int movieId) {
		movie.setId(movieId);
		if(movieRepo.existsById(movieId)) {
			return movieRepo.save(movie);
		}
		return null;
	}

	@Override
	public boolean deleteMovie(int movieId) {
		boolean isDeleted = false;
		Optional<Movie> movieOp = movieRepo.findById(movieId);
		if(movieOp.isPresent()) {
			Movie movie = movieOp.get();
				movieRepo.deleteById(movieId);
				isDeleted = true;
//			if(movie.getSnackId().getId() == snackId) {
//			}
			
		}
		return isDeleted;
	}

	@Override
	public List<Movie> findMovieByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return movieRepo.findByTitleLike(keyword);
	}
	
	

}
