package spring6andTesting.restJPA.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.transaction.Transactional;
import spring6andTesting.restJPA.bootstrap.BootstrapDataBeer;
import spring6andTesting.restJPA.entities.Beer;
import spring6andTesting.restJPA.entities.BeerOrder;
import spring6andTesting.restJPA.entities.Customer;
import spring6andTesting.restJPA.services.BeerCsvService;
import spring6andTesting.restJPA.services.BeerCsvServiceImpl;
import spring6andTesting.webExample.BootstrapData;

@SpringBootTest
class BeerOrderRepositoryTest {

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Customer testCustomer;
    Beer testBeer;

    @BeforeEach
    void setUp() {
        testCustomer = customerRepository.findAll().get(0);
        testBeer = beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testBeerOrders() {
        System.out.println(beerOrderRepository.count());
        System.out.println(customerRepository.count());
        System.out.println(beerRepository.count());
        System.out.println(testCustomer.getName());
        System.out.println(testBeer.getBeerName());
        
        BeerOrder beerOrder = BeerOrder.builder()
        		.customerRef("test order")
        		.customer(testCustomer)
        		.build();
        
        BeerOrder savedBeerOrders = beerOrderRepository.saveAndFlush(beerOrder);
        System.out.println(savedBeerOrders.getCustomerRef());
        
    }
}