package com.skilldistillery.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.movies.entities.Snack;
import com.skilldistillery.movies.repositories.SnackRepository;

@Service
public class SnackServiceImpl implements SnackService {

	@Autowired
	private SnackRepository snackRepo;

	@Override
	public List<Snack> getAllSnacks() {
		return snackRepo.findAll();
	}

	@Override
	public Snack getById(int snackId) {
		Optional<Snack> op = snackRepo.findById(snackId);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public Snack addNewSnack(Snack snack) {
		Snack newSnack = snackRepo.save(snack);
		return newSnack;
	}

	@Override
	public Snack updateSnack(Snack snack, int snackId) {
		snack.setId(snackId);
		if(snackRepo.existsById(snackId)) {
			return snackRepo.save(snack);
		}
		return null;
	}

	@Override
	public boolean deleteMovie(int snackId) {
		boolean isDeleted = false;
		Optional<Snack> snackOp = snackRepo.findById(snackId);
		if(snackOp.isPresent()) {
			Snack snack = snackOp.get();
			if(snack.getId() == snackId) {
				snackRepo.deleteById(snackId);
				isDeleted = true;
			}
			
		}
		return isDeleted;
	}

	@Override
	public List<Snack> findSnackByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return snackRepo.findByNameLike(keyword);
	}
	
	
}
