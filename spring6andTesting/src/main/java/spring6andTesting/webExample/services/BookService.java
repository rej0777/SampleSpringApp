package spring6andTesting.webExample.services;

import spring6andTesting.webExample.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
