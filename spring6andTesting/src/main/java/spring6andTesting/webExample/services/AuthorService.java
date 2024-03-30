package spring6andTesting.webExample.services;

import spring6andTesting.webExample.domain.Author;


public interface AuthorService {

    Iterable<Author> findAll();
}