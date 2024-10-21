package spring6andTesting.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import spring6andTesting.entities.Beer;
import spring6andTesting.model.BeerStyle;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

	   Page<Beer> findAllByBeerNameIsLikeIgnoreCase(String beerName, Pageable pageable);

	   Page<Beer> findAllByBeerStyle(BeerStyle beerStyle, Pageable pageable);

	   Page<Beer> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName, BeerStyle beerStyle, Pageable pageable);
	
}
