package com.sda.advanced.tdd.assertj;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AssertJTest {

    @Test
    void assertJTest() {
        String text = "abc";
        assertThat(text).isEqualTo("abc");
//        assertThat(text).isEmpty();

        boolean isSomething = true;
        assertThat(isSomething).isTrue();
        assertThat(isSomething).isNotEqualTo(false);

        int number = 10;
//        assertThat(number).isZero();
        assertThat(number).isEqualTo(10);
        assertThat(number).isGreaterThan(9);
        assertThat(number).isGreaterThanOrEqualTo(10);
        assertThat(number).isLessThan(11);
        assertThat(number).isLessThanOrEqualTo(10);

        List<String> books = new ArrayList<>();
        books.add("book1");
        books.add("book2");
        books.add(null);
        books.add("book3");

        assertThat(books)
                .hasSize(4)
                .contains("book1")
                .doesNotContain("book4")
                .containsNull();
    }

}
