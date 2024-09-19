package spring6andTesting.restJPA.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import spring6andTesting.restJPA.entities.Customer;

@DataJpaTest
@TestPropertySource("classpath:application-localmysql.properties")
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
