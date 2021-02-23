package com.sda.advanced.tdd.junit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Junit5ExceptionTest {

    @Test
    void testHappyPath() {
        int actual = Integer.parseInt("1");

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void testExpectedException() {
        // assert throws (exception type, code that could throw exception
        assertThrows(
                NumberFormatException.class, () -> Integer.parseInt("a")
        );
    }

    @Test
    void testExpectedExceptionWithSuperType() {
        assertThrows(
                IllegalArgumentException.class, () -> Integer.parseInt("a")
        );
    }
}
