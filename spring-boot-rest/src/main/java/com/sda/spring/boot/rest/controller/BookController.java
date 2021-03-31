package com.sda.spring.boot.rest.controller;

import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/books")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // TODO: replace with ResponseEntity.ok / not found
    // post /api/books
    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
        BookResponse response = bookService.save(request);
        ResponseEntity
                .ok();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // get /api/books
    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    // put /api/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(
            @PathVariable(name = "id") Long id,
            @RequestBody BookRequest request) {

        BookResponse response = bookService.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // get /api/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(
            @PathVariable(name = "id") Long id) {

        BookResponse response = bookService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // delete /api/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable(name = "id") Long id) {

        bookService.delete(id);
        return ResponseEntity.ok("book deleted");
    }
}
