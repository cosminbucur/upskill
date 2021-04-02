package com.sda.spring.boot.rest.service;

import com.sda.spring.boot.rest.dto.BookMapper;
import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.exception.DuplicateBookException;
import com.sda.spring.boot.rest.exception.NotFoundException;
import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookResponse save(BookRequest request) {
        log.info("saving book with data: {}", request);
        // prevent duplicate title
        // find by title
        Book existingBook = bookRepository.findByTitle(request.getTitle());
        if (existingBook != null) {
            throw new DuplicateBookException("book with title: " + request.getTitle() + " already exists");
        }

        // request to entity
        Book book = bookMapper.toEntity(request);
        Book savedBook = bookRepository.save(book);
        // entity to response
        return bookMapper.toDto(savedBook);
    }

    public List<BookResponse> findAll() {
        log.info("find all books...");

        List<Book> books = bookRepository.findAll();
        return bookMapper.toDto(books);
    }

    public BookResponse findById(Long id) {
        log.info("find book with id: {}", id);
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("book not found"));
        return bookMapper.toDto(foundBook);
    }

    public List<BookResponse> findByAuthor(String author) {
        log.info("find book by author: {}", author);

        List<Book> books = bookRepository.findByAuthor(author);
        return bookMapper.toDto(books);
    }

    public BookResponse update(Long id, BookRequest request) {
        log.info("updating book with id: {} and data: {}", id, request);

        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("book not found"));
        Book updatedBook = bookMapper.toEntity(foundBook, request);
        Book savedBook = bookRepository.save(updatedBook);
        return bookMapper.toDto(savedBook);
    }

    public void delete(Long id) {
        log.info("delete book with id: {}", id);

        bookRepository.deleteById(id);
    }
}
