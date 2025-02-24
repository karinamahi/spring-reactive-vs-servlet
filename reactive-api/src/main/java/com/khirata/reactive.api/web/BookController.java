package com.khirata.reactive.api.web;

import com.khirata.reactive.api.domain.Book;
import com.khirata.reactive.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    Mono<Book> create(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping
    Flux<Book> list() {
        return bookService.listBooks();
    }
}
