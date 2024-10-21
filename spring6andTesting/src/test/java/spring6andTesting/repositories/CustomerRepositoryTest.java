package spring6andTesting.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import spring6andTesting.bootstrap.BootstrapDataBeer;
import spring6andTesting.entities.Customer;
import spring6andTesting.repositories.CustomerRepository;
import spring6andTesting.services.BeerCsvServiceImpl;

@DataJpaTest
@Import({BootstrapDataBeer.class, BeerCsvServiceImpl.class})
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("localmysql")
class CustomerRepositoryTest {

	   @Autowired
	    CustomerRepository customerRepository;

	    @Test
	    void testSaveCustomer() {
	        Customer customer = customerRepository.save(Customer.builder()
	                        .name("New Name")
	                .build());

	        assertThat(customer.getId()).isNotNull();

	    }

}
