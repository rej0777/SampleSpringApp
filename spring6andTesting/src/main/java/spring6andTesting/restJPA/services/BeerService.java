package spring6andTesting.restJPA.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import spring6andTesting.restJPA.model.BeerDTO;
import spring6andTesting.restJPA.model.BeerStyle;

public interface BeerService {

    Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);
}