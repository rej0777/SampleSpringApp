package spring6andTesting.restJPA.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6andTesting.restJPA.entities.Beer;
import spring6andTesting.restJPA.model.BeerStyle;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

	   List<Beer> findAllByBeerNameIsLikeIgnoreCase(String beerName);

	   List<Beer> findAllByBeerStyle(BeerStyle beerStyle);

	   List<Beer> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName, BeerStyle beerStyle);
	
}
