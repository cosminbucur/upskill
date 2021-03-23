package com.sda.spring.data.jpa.optionals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Optional;

@Configuration
public class OptionalsConfig {

    private static final Logger log = LoggerFactory.getLogger(OptionalsConfig.class);

    @Autowired
    public BookRepository bookRepository;

    @Bean
    public CommandLineRunner optionalsData() {
        return args -> {
            Book book = new Book("title", "author", LocalDate.now());
            Book savedBook = bookRepository.save(book);

            Long id = savedBook.getId();
            findBookByIdOptionalGet(id);
            findBookByIdOptionalIfPresent(id);
            findBookByIdOptionalOrElseThrow(id);
        };
    }

    private void findBookByIdOptionalGet(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            log.info("saved book: {}", book);
        }
    }

    private void findBookByIdOptionalIfPresent(Long id) {
        bookRepository.findById(id)
                .ifPresent(book -> log.info("saved book: {}", book));
    }

    private void findBookByIdOptionalOrElseThrow(Long id) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));
        log.info("found book: {}", foundBook);
    }


}
