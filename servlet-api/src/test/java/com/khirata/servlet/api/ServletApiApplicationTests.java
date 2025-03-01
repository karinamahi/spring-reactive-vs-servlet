package com.khirata.servlet.api;

import com.khirata.servlet.api.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServletApiApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void test() {
		Book book = new Book(null, "Book 1", "Book Desc", "Publisher 1");
		Book postResponse = restTemplate.postForObject("/books", book, Book.class);

		assertNotNull(postResponse.id());
		assertEquals(book.title(), postResponse.title());
		assertEquals(book.subtitle(), postResponse.subtitle());
		assertEquals(book.publisher(), postResponse.publisher());

		Book[] books = restTemplate.getForObject("/books", Book[].class);
		assertNotNull(books);
		assertTrue(books.length == 1);

		Book bookResponse = books[0];
		assertNotNull(bookResponse.id());
		assertEquals(book.title(), bookResponse.title());
		assertEquals(book.subtitle(), bookResponse.subtitle());
		assertEquals(book.publisher(), bookResponse.publisher());
	}
}
