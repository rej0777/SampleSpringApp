package spring6andTesting.rest.services;

import java.util.List;
import java.util.UUID;

import spring6andTesting.rest.Beer;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

	Beer saveNewBeer(Beer bear);

	void updateBeerById(UUID beerId, Beer beer);

	void deleteById(UUID beerId);

	void patchBeerById(UUID beerId, Beer beer);
}