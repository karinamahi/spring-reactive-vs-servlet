package com.khirata.servlet.api.service;

import com.khirata.servlet.api.domain.Book;
import com.khirata.servlet.api.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book user) {
        return bookRepository.save(user);
    }

    public Iterable<Book> listBooks() {
        return bookRepository.findAll();
    }
}
