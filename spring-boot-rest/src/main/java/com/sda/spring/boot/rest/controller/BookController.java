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

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
        BookResponse response = bookService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(
            @PathVariable(name = "id") Long id) {

        BookResponse response = bookService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(
            @RequestParam(name = "authorName") String authorName) {

        List<BookResponse> response = bookService.findByAuthor(authorName);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(
            @PathVariable(name = "id") Long id,
            @RequestBody BookRequest request) {

        BookResponse response = bookService.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {

        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
