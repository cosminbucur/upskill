package com.sda.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookRepositoryIntegrationTest {

    private static final BookRepository bookRepository1 = new BookInMemoryDao();
    private static final BookRepository bookRepository = new BookJdbcDao();

    @BeforeEach
    void setUp() {
        bookRepository.findAll()
                .forEach(book -> bookRepository.delete(book.getId()));
    }

    @Test
    void givenBook_whenCreate_thenReturnBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishedDate(LocalDate.now());

        // when
        Book actualBook = bookRepository.create(book);

        // then
        assertThat(actualBook.getId()).isNotNull();
    }

    @Test
    void given2Books_whenFindAll_thenReturnAList() {
        // given
        Book book1 = new Book();
        book1.setTitle("title");
        book1.setAuthor("author");
        book1.setPublishedDate(LocalDate.now());

        Book book2 = new Book();
        book2.setTitle("title2");
        book2.setAuthor("author2");
        book2.setPublishedDate(LocalDate.now());

        bookRepository.create(book1);
        bookRepository.create(book2);

        // when
        List<Book> actual = bookRepository.findAll();

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void given2BooksWithSameAuthor_whenFindByAuthor_thenReturn2Books() {
        // given
        String sameAuthor = "author";

        Book book1 = new Book();
        book1.setTitle("title");
        book1.setAuthor(sameAuthor);
        book1.setPublishedDate(LocalDate.now());

        Book book2 = new Book();
        book2.setTitle("title2");
        book2.setAuthor(sameAuthor);
        book2.setPublishedDate(LocalDate.now());

        bookRepository.create(book1);
        bookRepository.create(book2);

        // when
        List<Book> actual = bookRepository.findByAuthor(sameAuthor);

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    void givenBook_whenFindById_thenReturnBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishedDate(LocalDate.now());

        Book expectedBook = bookRepository.create(book);

        // when
        Book actualBook = bookRepository.findById(expectedBook.getId()).get();

        // then
        assertThat(actualBook.getId()).isEqualTo(expectedBook.getId());
    }

    @Test
    void givenBook_whenFindByTitle_thenReturnBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishedDate(LocalDate.now());

        Book expectedBook = bookRepository.create(book);

        // when
        Book actualBook = bookRepository.findByTitle(expectedBook.getTitle()).get();

        // then
        assertThat(actualBook.getId()).isEqualTo(expectedBook.getId());
    }

    @Test
    void givenBook_whenUpdate_thenReturnBook() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishedDate(LocalDate.now());

        Book bookToUpdate = bookRepository.create(book);

        // modify book
        Book bookData = new Book();
        bookData.setTitle("another title");
        bookData.setAuthor("another author");
        bookData.setPublishedDate(LocalDate.now().plusDays(2));

        // when
        Book updatedBook = bookRepository.update(bookToUpdate.getId(), bookData);

        // then
        assertThat(updatedBook.getTitle()).isEqualTo(bookData.getTitle());
    }

    @Test
    void givenBook_whenDelete_thenDbSize0() {
        // given
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublishedDate(LocalDate.now());

        Book bookToDelete = bookRepository.create(book);

        // when
        bookRepository.delete(bookToDelete.getId());

        // then
        assertThat(bookRepository.findAll()).isEmpty();
    }
}