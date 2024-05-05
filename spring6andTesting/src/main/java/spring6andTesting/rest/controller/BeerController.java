package spring6andTesting.rest.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring6andTesting.rest.Beer;
import spring6andTesting.rest.services.BeerService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.UUID;


@Slf4j
//@AllArgsConstructor
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;
    
    @PatchMapping("beerId")
    public ResponseEntity<Beer>updateBeerPatchById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer){
    	
    	beerService.patchBeerById(beerId, beer);
    	
    	return new ResponseEntity<Beer>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("beerId")
    public ResponseEntity<Beer>deleteById(@PathVariable("beerId") UUID beerId){
    	
    	beerService.deleteById(beerId);
    	return new ResponseEntity<Beer>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("beerId")
    public ResponseEntity<Beer> updateById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer){
    
    	beerService.updateBeerById(beerId, beer);
    	return new ResponseEntity<Beer>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Beer> handlePost(@RequestBody Beer beer){

        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders heeaders = new HttpHeaders( );
        heeaders.add("Location","/api/v1/beer" + savedBeer.getId().toString());
        return new ResponseEntity<Beer>(heeaders ,HttpStatus.CREATED);
    }
    

    @GetMapping
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }

    @GetMapping("/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(beerId);
    }

}