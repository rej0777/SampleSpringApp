package spring6andTesting.restJPA.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.validation.ConstraintViolationException;
import spring6andTesting.restJPA.entities.Beer;
import spring6andTesting.restJPA.model.BeerStyle;

@DataJpaTest
class BeerRepositoryTest {

	@Autowired
	BeerRepository beerRepository;
	
	@Test
	void testSaveBeerTooLong() {
		
		assertThrows(ConstraintViolationException.class, ()->{
			Beer saveBeer = beerRepository.save(Beer.builder()
				.beerName("My Beerbiger that 50 --123456789123456789123456789123456789123456789123456789")
				.beerStyle(BeerStyle.PALE_ALE)
				.upc("2354677")
				.price(new BigDecimal("11.99"))
				.build());
		
		beerRepository.flush();
		});
		
		
		
	//	assertThat(saveBeer).isNotNull();
	//	assertThat(saveBeer.getId()).isNotNull();
	}
	
	@Test
	void testSaveBeer() {
		Beer saveBeer = beerRepository.save(Beer.builder()
				.beerName("My Beer")
				.beerStyle(BeerStyle.PALE_ALE)
				.upc("2354677")
				.price(new BigDecimal("11.99"))
				.build());
		
		beerRepository.flush();
		
		assertThat(saveBeer).isNotNull();
		assertThat(saveBeer.getId()).isNotNull();
	}


}
