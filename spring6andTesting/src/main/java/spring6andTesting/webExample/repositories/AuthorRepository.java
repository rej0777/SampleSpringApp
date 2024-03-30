package spring6andTesting.webExample.repositories;

import org.springframework.data.repository.CrudRepository;

import spring6andTesting.webExample.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}