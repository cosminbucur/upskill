package com.sda.advanced.tdd.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CalculatorTest {

    @Test
    void shouldReturnZeroOnEmptyString() {
        // when
        int actual = Calculator.add("");

        // then
        assertThat(actual).isZero();
    }

    @Test
    void shouldReturnNumberOnNumber() {
        // when
        int actual = Calculator.add("1");

        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void shouldReturnSumOnTwoNumbersDelimitedByComma() {
        // when
        int actual = Calculator.add("1,2");

        // then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void shouldReturnSumOnMultipleNumbers() {
        // when
        int actual = Calculator.add("1,2,3");

        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void shouldAcceptNewLineAsValidDelimiter() {
        // when
        int actual = Calculator.add("1,2\n3");

        // then
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void shouldRaiseExceptionOnNegatives() {
        Throwable exception = catchThrowable(() -> Calculator.add("-1,2,3"));

        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative number not supported");
    }
}
