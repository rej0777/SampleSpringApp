package spring6andTesting.webExample.repositories;

import org.springframework.data.repository.CrudRepository;

import spring6andTesting.webExample.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}