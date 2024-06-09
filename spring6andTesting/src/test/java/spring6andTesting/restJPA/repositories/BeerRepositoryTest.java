package spring6andTesting.restJPA.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import spring6andTesting.restJPA.entities.Beer;

@DataJpaTest
class BeerRepositoryTest {

	@Autowired
	BeerRepository beerRepository;
	
	
	@Test
	void testSaveBeer() {
		Beer saveBeer = beerRepository.save(Beer.builder()
				.beerName("My Beer")
				.build());
		
		assertThat(saveBeer).isNotNull();
		assertThat(saveBeer.getId()).isNotNull();
	}
	/*
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
*/
}
