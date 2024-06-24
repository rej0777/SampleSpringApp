package spring6andTesting.restJPA.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring6andTesting.restJPA.mappers.BeerMapper;
import spring6andTesting.restJPA.model.BeerDTO;
import spring6andTesting.restJPA.repositories.BeerRepository;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public List<BeerDTO> listBeers() {
 	
        return beerRepository.findAll()
        		.stream()
        		.map(beerMapper::beerToBeerDto)
        		.collect(Collectors.toList());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {

        return Optional.ofNullable(beerMapper.beerToBeerDto(beerRepository.findById(id).orElse(null)));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beer))) ;
    }

    @Override
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer) {
    	
    	AtomicReference<Optional<BeerDTO>> atomicReference =new AtomicReference<Optional<BeerDTO>>(); 
    	
    	beerRepository.findById(beerId).ifPresentOrElse(foundBeer -> {
    		foundBeer.setBeerName(beer.getBeerName());
    		foundBeer.setBeerStyle(beer.getBeerStyle());
    		foundBeer.setUpc(beer.getUpc());
    		foundBeer.setPrice(beer.getPrice());
    		atomicReference.set(Optional.of(beerMapper.beerToBeerDto(beerRepository.save(foundBeer) )));  		
    	}, ()->{
    		atomicReference.set(Optional.empty());
    	} );
    	
    	return atomicReference.get();

    }

    @Override
    public Boolean deleteById(UUID beerId) {

    	if (beerRepository.existsById(beerId)) {
			beerRepository.deleteById(beerId);
			return true;
		}
    	return false;
    	
    	
    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beer) {

    }
}
