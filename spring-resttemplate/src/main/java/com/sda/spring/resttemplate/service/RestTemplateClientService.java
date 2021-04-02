package com.sda.spring.resttemplate.service;

import com.sda.spring.resttemplate.dto.BookRequest;
import com.sda.spring.resttemplate.dto.BookResponse;
import com.sda.spring.resttemplate.dto.BookResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RestTemplateClientService {

    public static final String BOOKS_RESOURCE = "http://localhost:8081/api/books";
    private static final Logger log = LoggerFactory.getLogger(RestTemplateClientService.class);
    @Autowired
    private RestTemplate restTemplate;

    public BookResponse save(BookRequest request) {
        log.info("rest template create");

        return restTemplate.postForObject(BOOKS_RESOURCE, request, BookResponse.class);
    }

    public List<BookResponse> findAll() {
        log.info("rest template find all");

        ResponseEntity<BookResponse[]> response = restTemplate.getForEntity(
                BOOKS_RESOURCE,
                BookResponse[].class);

        BookResponse[] responses = response.getBody();
        return Arrays.asList(responses);
    }

    // good practice
    public BookResponseList findAllUsingWrapperClass() {
        log.info("rest template find all");

        return restTemplate.getForObject(BOOKS_RESOURCE, BookResponseList.class);
    }

    public BookResponse findById(Long bookId) {
        log.info("rest template find by id");

        return restTemplate.getForObject(BOOKS_RESOURCE + "/" + bookId, BookResponse.class);
    }

    public void update(Long id, BookRequest request) {
        log.info("rest template update");

        restTemplate.put(BOOKS_RESOURCE + "/" + id, request);
    }

    public void delete(Long id) {
        log.info("rest template delete");

        // name of param - value of param
        Map<String, Long> params = Map.of("id", id);
        restTemplate.delete(BOOKS_RESOURCE + "/" + id, params);
    }
}
