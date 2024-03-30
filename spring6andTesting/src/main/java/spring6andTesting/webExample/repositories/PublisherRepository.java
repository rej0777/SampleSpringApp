package spring6andTesting.webExample.repositories;

import org.springframework.data.repository.CrudRepository;

import spring6andTesting.webExample.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}