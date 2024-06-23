package spring6andTesting.restJPA.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import spring6andTesting.restJPA.model.BeerDTO;

public interface BeerService {

    List<BeerDTO> listBeers();

  Optional<BeerDTO> getBeerById(UUID id);

	BeerDTO saveNewBeer(BeerDTO bear);

	Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

	void deleteById(UUID beerId);

	void patchBeerById(UUID beerId, BeerDTO beer);
}