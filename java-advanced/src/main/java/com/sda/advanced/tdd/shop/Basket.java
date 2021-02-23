package com.sda.advanced.tdd.shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }

    public void clear() {
        books = new ArrayList<>();
    }

    public int sumPrices() {
        int sum1 = books.stream()
                .mapToInt(book -> book.getPrice())
                .sum();

        return books.stream()
                .map(Book::getPrice)
                .reduce(0, Integer::sum);
    }
}
