package com.khirata.reactive.api;

import com.khirata.reactive.api.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReactiveApiApplicationTests {
	@Autowired
	private WebTestClient webClient;
	@Test
	void test() {
		Book book = new Book(null, "Book 1", "Book Desc", "Publisher 1");

		webClient.post().uri("/books").bodyValue(book)
				.exchange()
				.expectBody(Book.class)
				.value(postResponse -> {
					assertNotNull(postResponse.id());
					assertEquals(book.title(), postResponse.title());
					assertEquals(book.subtitle(), postResponse.subtitle());
					assertEquals(book.publisher(), postResponse.publisher());
				});

		webClient.get().uri("/books")
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBodyList(Book.class)
				.value(response -> {
					Book bookResponse  = response.get(0);
					assertNotNull(bookResponse.id());
					assertEquals(book.title(), bookResponse.title());
					assertEquals(book.subtitle(), bookResponse.subtitle());
					assertEquals(book.publisher(), bookResponse.publisher());
				});
	}
}
