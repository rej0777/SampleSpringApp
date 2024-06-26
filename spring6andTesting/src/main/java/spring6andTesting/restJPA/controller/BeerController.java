package spring6andTesting.restJPA.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring6andTesting.restJPA.model.BeerDTO;
import spring6andTesting.restJPA.services.BeerService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;


@Slf4j
//@AllArgsConstructor
@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v1/beer")
public class BeerController {

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    private final BeerService beerService;

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity<BeerDTO> updateBeerPatchById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer){

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity<BeerDTO>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){

    	if (!beerService.deleteById(beerId)  ) {
			throw new NotFoundException();
		}
       

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer){

    	if (beerService.updateBeerById(beerId, beer).isEmpty()) {
			throw new NotFoundException();
		}
    	
     //   beerService.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity handlePost(@Validated @RequestBody BeerDTO beer){

        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = BEER_PATH)
    public List<BeerDTO> listBeers(){ 	
        return beerService.listBeers();
    }


    
    @GetMapping(value = BEER_PATH_ID)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }

    
}