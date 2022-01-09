package com.skilldistillery.movies.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Movie movie;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAMovieNight");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		movie = em.find(Movie.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		em.close();
		movie = null;
	}

	@Test
	void test_Movie_title_mappings() {
		assertNotNull(movie);
		assertEquals("Titanic", movie.getTitle());
	}
	
	@Test
	void test_Movie_basic_mappings() {
		assertNotNull(movie);
		assertEquals("Titanic", movie.getTitle());
		assertEquals("Drama", movie.getCategory());
		assertEquals(true, movie.isHaveWatched());
		assertEquals(1998, movie.getDateWatched().getYear());
		
	}
	
	@Test
	void test_Movie_seasonAndEpsiode_mappings() {
		movie = em.find(Movie.class, 29);
		assertNotNull(movie);
		assertEquals("Witcher", movie.getTitle());
		assertEquals(2, movie.getSeason());
		assertEquals(8, movie.getEpisode());
		assertEquals("Fantasy", movie.getCategory());
		assertEquals(true, movie.isHaveWatched());
		assertEquals(2022, movie.getDateWatched().getYear());
		assertEquals("Pizza", movie.getSnackId().getName());
		
	}
	
	@Test
	void test_Movie_to_Snack_mappings() {
		assertNotNull(movie);
		assertEquals("Popcorn", movie.getSnackId().getName());
		
	}

}
