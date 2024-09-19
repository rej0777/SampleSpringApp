package spring6andTesting.restJPA.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import spring6andTesting.restJPA.model.BeerDTO;
import spring6andTesting.restJPA.model.BeerStyle;

public interface BeerService {

    List<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory);

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);
}