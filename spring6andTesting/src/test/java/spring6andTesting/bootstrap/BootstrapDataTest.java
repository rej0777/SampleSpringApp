package spring6andTesting.bootstrap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import spring6andTesting.repositories.BeerRepository;
import spring6andTesting.repositories.CustomerRepository;
import spring6andTesting.services.BeerCsvService;
import spring6andTesting.services.BeerCsvServiceImpl;


@DataJpaTest
@Import(BeerCsvServiceImpl.class)
@ActiveProfiles("localmysql")
class BootstrapDataTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerCsvService csvService;

    BootstrapDataBeer bootstrapDataBeer;

    @BeforeEach
    void setUp() {
    	bootstrapDataBeer = new BootstrapDataBeer(beerRepository, customerRepository, csvService);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapDataBeer.run(null);

        assertThat(beerRepository.count()).isEqualTo(2413);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}