package spring6andTesting.react;


import spring6andTesting.rest.Beer;
import spring6andTesting.rest.controller.BeerController;
import spring6andTesting.rest.services.BeerService;
import spring6andTesting.rest.services.BeerServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;

//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(BeerController.class)
//@SpringBootTest(classes = BeerController.class)

class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerService beerService;

    BeerServiceImpl  beerServiceImpl = new BeerServiceImpl();
    
    
    @Test
    void testCreateNewBeer() throws JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.findAndRegisterModules();
    	Beer  beer = beerServiceImpl.listBeers().get(0);
    	
    	System.out.println(objectMapper.writeValueAsString(beer));
    }
    
    @Test
    void testListBeers() throws Exception {
    	given(beerService.listBeers()).willReturn(beerServiceImpl.listBeers());
    	
    	mockMvc.perform(get("/api/v1/beer/")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(status().isOk())
    			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
    			.andExpect(jsonPath("$.length", is(3))
    					);
    			
    	
    }
    
    @Test
    void getBeerById() throws Exception {
    	Beer testBeer = beerServiceImpl.listBeers().get(0);
    	
    	given(beerService.getBeerById(testBeer.getId())).willReturn(testBeer);//any(UUID.class)
    	
    	  mockMvc.perform(get("/api/v1/beer/" + testBeer.getId())
                  .accept(MediaType.APPLICATION_JSON))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$.id", is(testBeer.getId().toString())))
                  .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));
    }
}