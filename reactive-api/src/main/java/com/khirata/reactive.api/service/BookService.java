package com.khirata.reactive.api.service;

import com.khirata.reactive.api.domain.Book;
import com.khirata.reactive.api.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Mono<Book> createBook(Book user) {
        return bookRepository.save(user);
    }

    public Flux<Book> listBooks() {
        return bookRepository.findAll();
    }
}
