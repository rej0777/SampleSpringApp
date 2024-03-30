package spring6andTesting.webExample.services;



import org.springframework.stereotype.Service;

import spring6andTesting.webExample.domain.Book;
import spring6andTesting.webExample.repositories.BookRepository;


/**
 * Created by jt, Spring Framework Guru.
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}