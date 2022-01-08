package com.skilldistillery.movies.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnackTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Snack snack;

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
		snack = em.find(Snack.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		em.close();
		snack = null;
	}

	@Test
	void test_snack_basic_mapping() {
		assertNotNull(snack);
		assertEquals("Popcorn", snack.getName());
	}
	
	@Test
	void test_Snack_to_Movie_mappings() {
		assertNotNull(snack);
		assertNotNull(snack.getMovies().size());
		assertTrue(snack.getMovies().size() > 0);
	}

}
