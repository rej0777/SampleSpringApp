package spring6andTesting.restJPA.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;

import spring6andTesting.restJPA.model.BeerDTO;
import spring6andTesting.restJPA.model.BeerStyle;
import spring6andTesting.restJPA.repositories.BeerRepository;
import spring6andTesting.restJPA.services.BeerService;
import spring6andTesting.restJPA.services.BeerServiceImpl;
import spring6andTesting.restJPA.controller.BeerController;
import spring6andTesting.restJPA.entities.Beer;
import spring6andTesting.restJPA.mappers.BeerMapper;


@SpringBootTest
@TestPropertySource("classpath:application-localmysql.properties")
class BeerControllerIT {
	  @Autowired
	    BeerController beerController;

	    @Autowired
	    BeerRepository beerRepository;

	    @Autowired
	    BeerMapper beerMapper;

	    @Autowired
	    ObjectMapper objectMapper;

	    @Autowired
	    WebApplicationContext wac;

	    MockMvc mockMvc;

	    @BeforeEach
	    void setUp() {
	        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	    }
	    
	    
	    @Test
	    void testListBeerByStyleAndNameShowInwentoryTruePage2() {
	    	//mockMvc.perform(null)
	    }

	    @Test
	    void tesListBeersByStyleAndNameShowInventoryTrue() throws Exception {
	        mockMvc.perform(get(BeerController.BEER_PATH)
	                        .queryParam("beerName", "IPA")
	                        .queryParam("beerStyle", BeerStyle.IPA.name())
	                        .queryParam("showInventory", "true"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.size()", is(310)))
	                .andExpect(jsonPath("$.[0].quantityOnHand").value(IsNull.notNullValue()));
	    }

	    @Test
	    void tesListBeersByStyleAndNameShowInventoryFalse() throws Exception {
	        mockMvc.perform(get(BeerController.BEER_PATH)
	                        .queryParam("beerName", "IPA")
	                        .queryParam("beerStyle", BeerStyle.IPA.name())
	                        .queryParam("showInventory", "false"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.size()", is(310)))
	                .andExpect(jsonPath("$.[0].quantityOnHand").value(IsNull.nullValue()));
	    }
	    
	    

	    @Test
	    void tesListBeersByStyleAndName() throws Exception {
	        mockMvc.perform(get(BeerController.BEER_PATH)
	                        .queryParam("beerName", "IPA")
	                        .queryParam("beerStyle", BeerStyle.IPA.name()))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.size()", is(310)));
	    }

	    @Test
	    void tesListBeersByStyle() throws Exception {
	        mockMvc.perform(get(BeerController.BEER_PATH)
	                        .queryParam("beerStyle", BeerStyle.IPA.name()))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.size()", is(548)));
	    }

	    @Test
	    void tesListBeersByName() throws Exception {
	        mockMvc.perform(get(BeerController.BEER_PATH)
	                .queryParam("beerName", "IPA"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.size()", is(336)));
	    }

	    @Test
	    void testPatchBeerBadName() throws Exception {
	        Beer beer = beerRepository.findAll().get(0);

	        Map<String, Object> beerMap = new HashMap<>();
	        beerMap.put("beerName", "New Name 1234567890123456789012345890123456789012");

	        mockMvc.perform(patch(BeerController.BEER_PATH_ID, beer.getId())
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .accept(MediaType.APPLICATION_JSON)
	                        .content(objectMapper.writeValueAsString(beerMap)))
	                .andExpect(status().isBadRequest());

	    }

	    @Test
	    void testDeleteByIDNotFound() {
	        assertThrows(NotFoundException.class, () -> {
	            beerController.deleteById(UUID.randomUUID());
	        });
	    }

	    @Rollback
	    @Transactional
	    @Test
	    void deleteByIdFound() {
	        Beer beer = beerRepository.findAll().get(0);

	        ResponseEntity responseEntity = beerController.deleteById(beer.getId());
	        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

	        assertThat(beerRepository.findById(beer.getId()).isEmpty());
	    }

	    @Test
	    void testUpdateNotFound() {
	        assertThrows(NotFoundException.class, () -> {
	            beerController.updateById(UUID.randomUUID(), BeerDTO.builder().build());
	        });
	    }

	    @Rollback
	    @Transactional
	    @Test
	    void updateExistingBeer() {
	        Beer beer = beerRepository.findAll().get(0);
	        BeerDTO beerDTO = beerMapper.beerToBeerDto(beer);
	        beerDTO.setId(null);
	        beerDTO.setVersion(null);
	        final String beerName = "UPDATED";
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
	        List<BeerDTO> dtos = beerController.listBeers(null, null, false);

	        assertThat(dtos.size()).isEqualTo(2413);
	    }

	    @Rollback
	    @Transactional
	    @Test
	    void testEmptyList() {
	        beerRepository.deleteAll();
	        List<BeerDTO> dtos = beerController.listBeers(null, null, false);

	        assertThat(dtos.size()).isEqualTo(0);
	    }
}