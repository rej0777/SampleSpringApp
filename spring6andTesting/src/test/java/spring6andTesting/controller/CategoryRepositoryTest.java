package spring6andTesting.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;
import spring6andTesting.entities.Beer;
import spring6andTesting.entities.Category;
import spring6andTesting.repositories.BeerRepository;
import spring6andTesting.repositories.CategoryRepository;

@SpringBootTest
@ActiveProfiles("localmysql")
class CategoryRepositoryTest {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	BeerRepository beerRepository;
	
	Beer testBeer;
	
	@BeforeEach
	void setUp() {
		testBeer = beerRepository.findAll().get(0); 
	}
	
	@Transactional
	@Test
	void testAddCategory() {
		Category saveCat = categoryRepository.save(Category.builder()
				.description("Ales")
				.build());
		
		testBeer.addCategory(saveCat);
		Beer saveBeer = beerRepository.save(testBeer);
		
		System.out.println(saveBeer);
		
	}
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
