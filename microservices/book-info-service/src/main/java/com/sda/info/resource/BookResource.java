package com.sda.info.resource;

import com.sda.info.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/books")
@RestController
public class BookResource {

    @GetMapping("/{bookId}")
    public Book getBookInfo(@PathVariable String bookId) {
        return new Book(bookId, "title", "author");
    }
}
