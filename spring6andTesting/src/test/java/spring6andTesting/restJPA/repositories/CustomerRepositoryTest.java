package spring6andTesting.restJPA.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import spring6andTesting.restJPA.entities.Customer;

@DataJpaTest
class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	void testSaveCustomer() {
		Customer customer = customerRepository.save(Customer.builder()
				.name("Nev Name")
				.build());
		
		assertThat(customer.getId()).isNotNull();
		
	}
	/*
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}*/

}
