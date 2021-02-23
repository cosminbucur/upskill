package com.sda.advanced.tdd.shop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartTest {

    // add books to basket
    @Test
    void givenBook_whenAdd_thenSizeIsOne() {
        // given
        Book book = new Book("game of thrones", "george martin", 20);
        Basket basket = new Basket();

        // when
        basket.addBook(book);

        // then
        assertThat(basket.findAll().size()).isEqualTo(1);
    }

    @Test
    void given2Book_whenFindAll_thenReturnTwoBooks() {
        // given
        Book book1 = new Book("game of thrones1", "george martin", 20);
        Book book2 = new Book("game of thrones2", "george martin", 20);
        Basket basket = new Basket();
        basket.addBook(book1);
        basket.addBook(book2);

        // when
        List<Book> actual = basket.findAll();

        // then
        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void givenBook_whenClear_thenBasketShouldBeEmpty() {
        // given
        Book book = new Book("game of thrones1", "george martin", 20);
        Basket basket = new Basket();
        basket.addBook(book);

        // when
        basket.clear();

        // then
        assertThat(basket.findAll()).isEmpty();
    }

    @Test
    void given2Books_whenSumPrices_thenReturnCorrectPrice() {
        // given
        Book book1 = new Book("game of thrones1", "george martin", 20);
        Book book2 = new Book("game of thrones2", "george martin", 30);
        Basket basket = new Basket();
        basket.addBook(book1);
        basket.addBook(book2);

        // when
        int actualPrice = basket.sumPrices();

        // then
        assertThat(actualPrice).isEqualTo(50);
    }
}
