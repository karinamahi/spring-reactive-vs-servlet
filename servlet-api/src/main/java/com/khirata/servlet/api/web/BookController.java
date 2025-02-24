package com.khirata.servlet.api.web;

import com.khirata.servlet.api.domain.Book;
import com.khirata.servlet.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    Book create(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping
    Iterable<Book> list() {
        return bookService.listBooks();
    }
}
