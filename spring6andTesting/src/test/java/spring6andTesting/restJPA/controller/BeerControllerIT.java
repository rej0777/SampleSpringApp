package spring6andTesting.restJPA.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import spring6andTesting.restJPA.model.BeerDTO;
import spring6andTesting.restJPA.repositories.BeerRepository;
import spring6andTesting.restJPA.controller.BeerController;
import spring6andTesting.restJPA.entities.Beer;
import spring6andTesting.restJPA.mappers.BeerMapper;

@SpringBootTest
class BeerControllerIT {

	@Autowired
	BeerController beerController;
	
	@Autowired
	BeerRepository beerRepository;
	
	@Autowired
	BeerMapper beerMapper;
	
	
	@Test
	void testDeleteByIdNotFound() {
		assertThrows(NotFoundException.class, () -> {
		
			beerController.deleteById(UUID.randomUUID());
			
		}) ;//beerController.updateById(UUID.randomUUID(), BeerDTO.builder().build()));
	}
	
	@Transactional
	@Rollback
	@Test
	void deleteByIdFound() {
		Beer beer = beerRepository.findAll().get(0);
		
		ResponseEntity responseEntity = beerController.deleteById(beer.getId());
		
		assertThat(beerRepository.findById(beer.getId()).isEmpty());
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
		
	//	Beer foundBeer = beerRepository.findById(beer.getId()).get();
	//	assertThat(foundBeer).isNull();
	}
	
	@Test
	void testUpdateNotFound() {
		assertThrows(NotFoundException.class, () -> beerController.updateById(UUID.randomUUID(), BeerDTO.builder().build()));
	}
	
	@Transactional
	@Rollback
	@Test
	void updateExistingBeer() {
		Beer beer = beerRepository.findAll().get(0);
		BeerDTO beerDTO = beerMapper.beerToBeerDto(beer);
		beerDTO.setId(null);
		beerDTO.setVersion(null);
		final String beerName = "UPdATET";
		beerDTO.setBeerName(beerName);
		
		ResponseEntity responseEntity = beerController.updateById(beer.getId(), beerDTO); 
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
		
		Beer updatedBeer = beerRepository.findById(beer.getId()).get();
		assertThat(updatedBeer.getBeerName()).isEqualTo(beerName);
		
		
	}
	
	@Rollback
	@Transactional
	@Test
	void saveNewBeerTest() {		
		BeerDTO beerDTO = BeerDTO.builder()
				.beerName("New Beer")
				.build();
		
		ResponseEntity responseEntity = beerController.handlePost(beerDTO);
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
		assertThat(responseEntity.getHeaders().getLocation()).isNotNull();
		
		String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
		UUID savedUUID = UUID.fromString(locationUUID[4]);
		
		Beer beer = beerRepository.findById(savedUUID).get();
		assertThat(beer).isNotNull();
	}
	
	@Test
	void testBeerIdNotFound() {
		assertThrows(NotFoundException.class, () -> {
			beerController.getBeerById(UUID.randomUUID());
		});
		
	}
	
	@Test
	void testGetById() {
		Beer beer = beerRepository.findAll().get(0);
		BeerDTO dto = beerController.getBeerById(beer.getId());
		assertThat(dto).isNotNull();
	}
	
	
	@Test
	void testListBeers() {		
		List<BeerDTO> dtos = beerController.listBeers();		
		assertThat(dtos.size()).isEqualTo(3);		
	}
	
	@Rollback
	@Transactional
	@Test
	void testEmptyListBeers() {
		beerRepository.deleteAll();
		List<BeerDTO> dtos = beerController.listBeers();
		
		assertThat(dtos.size()).isEqualTo(0);
		
	}
	
	
	
//	@Test
	void test() {
		fail("Not yet implemented");
	}

}
