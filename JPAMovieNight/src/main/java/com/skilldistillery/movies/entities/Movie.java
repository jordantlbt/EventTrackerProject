package com.skilldistillery.movies.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	
	private Integer season;
	
	
	private Integer episode;
	
	@Column(name="image_url")
	private String imageURL;
	private String category;
	
	@Column(name="have_watched")
	private boolean haveWatched;
	
	@Column(name="date_watched")
	private LocalDate dateWatched;
	
	@Column(name="date_plan_to_see")
	private LocalDate dateScheduled;
	
	@ManyToOne
	@JoinColumn(name="snack_id")
	private Snack snackId;
		
//-----------------------CONSTRUCTORS----------------------------------	

	
	
	public Movie() {
		super();
	}

	
	public Movie(String title) {
	super();
	this.title = title;
}


//-----------------------GETTERS/SETTERS----------------------------------	



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isHaveWatched() {
		return haveWatched;
	}

	public void setHaveWatched(boolean haveWatched) {
		this.haveWatched = haveWatched;
	}

	public LocalDate getDateWatched() {
		return dateWatched;
	}

	public void setDateWatched(LocalDate dateWatched) {
		this.dateWatched = dateWatched;
	}

	public LocalDate getDateScheduled() {
		return dateScheduled;
	}

	public void setDateScheduled(LocalDate dateScheduled) {
		this.dateScheduled = dateScheduled;
	}
	

	public Snack getSnackId() {
		return snackId;
	}


	public void setSnackId(Snack snackId) {
		this.snackId = snackId;
	}


	
//-----------------HASHCODE/EQUALS-------------------	

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id;
	}
	
	
//-----------------TOSTRING-------------------		
	

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + "]";
	}

}
