package com.sda.spring.resttemplate.service;

import com.sda.spring.resttemplate.dto.BookRequest;
import com.sda.spring.resttemplate.dto.BookResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RestTemplateClientServiceTest {

    @Autowired
    private RestTemplateClientService service;

    @BeforeEach
    void setUp() {
        service.findAll()
                .forEach(bookResponse -> service.delete(bookResponse.getId()));
    }

    @Test
    void save() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");

        // when
        BookResponse actual = service.save(bookRequest);

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    void findAll() {
        // given
        BookRequest bookRequest1 = new BookRequest();
        bookRequest1.setTitle("title1");
        bookRequest1.setAuthor("author");

        BookRequest bookRequest2 = new BookRequest();
        bookRequest2.setTitle("title2");
        bookRequest2.setAuthor("author");
        service.save(bookRequest1);
        service.save(bookRequest2);

        // when
        List<BookResponse> actual = service.findAll();

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void findById() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");

        BookResponse bookResponse = service.save(bookRequest);

        // when
        BookResponse actual = service.findById(bookResponse.getId());

        // then
        assertThat(actual.getTitle()).isEqualTo(bookRequest.getTitle());
    }

    @Test
    void update() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");

        BookResponse bookResponse = service.save(bookRequest);

        BookRequest updateRequest = new BookRequest();
        updateRequest.setTitle("title2");
        updateRequest.setAuthor("author2");

        // when
        service.update(bookResponse.getId(), updateRequest);

        BookResponse updateBook = service.findById(bookResponse.getId());
        // then
        assertThat(updateBook.getTitle()).isEqualTo(updateRequest.getTitle());
    }

    @Test
    void delete() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("title");
        bookRequest.setAuthor("author");

        BookResponse bookResponse = service.save(bookRequest);

        // when
        service.delete(bookResponse.getId());

        // then
        assertThat(service.findAll()).isEmpty();
    }
}
