package spring6andTesting.webExample.services;

import org.springframework.stereotype.Service;

import spring6andTesting.webExample.domain.Author;
import spring6andTesting.webExample.repositories.AuthorRepository;



@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}