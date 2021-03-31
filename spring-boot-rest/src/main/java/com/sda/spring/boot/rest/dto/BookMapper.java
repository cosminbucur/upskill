package com.sda.spring.boot.rest.dto;

import com.sda.spring.boot.rest.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public List<BookResponse> toDto(List<Book> books) {
        return books.stream()
                .map(book -> toDto(book))
                .collect(Collectors.toList());
    }

    public Book toEntity(BookRequest request) {
        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setPublished(request.getPublished());
        return book;
    }

    public BookResponse toDto(Book entity) {
        BookResponse response = new BookResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setAuthor(entity.getAuthor());
        response.setPublished(entity.getPublished());
        return response;
    }
}
