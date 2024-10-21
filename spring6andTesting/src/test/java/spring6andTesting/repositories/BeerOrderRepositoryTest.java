package spring6andTesting.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.transaction.Transactional;
import spring6andTesting.entities.Beer;
import spring6andTesting.entities.BeerOrder;
import spring6andTesting.entities.Customer;

@SpringBootTest
@ActiveProfiles("localmysql")
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