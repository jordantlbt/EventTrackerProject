package com.skilldistillery.movies.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Snack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="snackId")
	private List<Movie> movies;

	
	
//-----------------------CONSTRUCTORS----------------------------------	
	
	
	public Snack() {
		super();
	}

	public Snack(String name) {
		super();
		this.name = name;
	}

	
	
//-----------------------GETTERS/SETTERS----------------------------------	

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	
	
	
	public void addMovie(Movie movie) {
		if(movies == null) movies = new ArrayList<>();
		if(!movies.contains(movie)) {
			movies.add(movie);
				
			}
		}
	
	
	

//-----------------HASHCODE/EQUALS-------------------

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snack other = (Snack) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

//---------------------TOSTRING-----------------------	

	
	@Override
	public String toString() {
		return "Snack [id=" + id + ", name=" + name + "]";
	}

	

	 
	
	
	
}
