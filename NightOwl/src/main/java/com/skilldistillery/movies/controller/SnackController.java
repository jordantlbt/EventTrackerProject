package com.skilldistillery.movies.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.movies.entities.Snack;
import com.skilldistillery.movies.services.SnackService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4202"})
public class SnackController {
	
	@Autowired
	private SnackService snackServ;
	
	@GetMapping("snacks")
	public List<Snack> allSnacks(){
		return snackServ.getAllSnacks();
	}
	
	@GetMapping("snacks/{snackId}")
	public Snack findSnackById(@PathVariable Integer snackId, HttpServletResponse res) {
		Snack snack = snackServ.getById(snackId);
		if(snack == null) {
			res.setStatus(404);
		}
		return snack;
	}
	@PostMapping("snacks")
	public Snack addNewSnack(@RequestBody Snack snack, HttpServletResponse res) {
		try {
			Snack newSnack = snackServ.addNewSnack(snack);
			if(newSnack != null) {
				res.setStatus(201);
				return newSnack;
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return null;
	}
	
	@DeleteMapping("snacks/{snackId}")
	public void deleteSnack(@PathVariable Integer snackId, HttpServletResponse res) {
		try {
			snackServ.deleteSnack(snackId);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	@GetMapping("snacks/search/{keyword}")
	public List<Snack> findMovieByKeyword(@PathVariable String keyword, HttpServletResponse res){
		List<Snack> result = snackServ.findSnackByKeyword(keyword);
		if(result == null) {
			res.setStatus(404);
		}
		return result;
	}
	


}
