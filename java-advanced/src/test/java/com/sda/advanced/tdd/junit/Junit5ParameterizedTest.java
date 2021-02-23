package com.sda.advanced.tdd.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Junit5ParameterizedTest {

    // TDD - test driven development

    // red - green - refactor

    // divisible by 3

    private static Stream<Arguments> numberToMonth() {
        return Stream.of(
                Arguments.arguments(1, "Jan"),
                Arguments.arguments(6, "Jun"),
                Arguments.arguments(12, "Dec")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 15, -9})
    void shouldBeDivisibleByThree(int number) {
        // given

        // when
        boolean actual = UtilityClass.isDivisibleByThree(number);

        // then
        assertThat(actual).isTrue();
    }

    // null and empty - used for corner cases
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" "})
    void shouldReturnTrueForNullEmptyAndBlankStrings(String text) {
        boolean actual = UtilityClass.parseString(text);

        assertThat(actual).isTrue();
    }

    // enum
    @ParameterizedTest
    @EnumSource(
            value = Day.class,
            names = {"SATURDAY", "SUNDAY"}
    )
    void shouldBeWeekend(Day day) {
        boolean actual = MyCalendar.isWeekend(day);

        assertThat(actual).isTrue();
    }

    // multiple arguments
    @ParameterizedTest
    @MethodSource("numberToMonth")
    void shouldReturnMonthName(int monthNumber, String monthName) {
        String actual = MyCalendar.getMonthName(monthNumber);

        assertThat(actual).isEqualTo(monthName);
    }

    // read data from csv
    @ParameterizedTest
    @CsvFileSource(resources = "/shopping.csv")
    void shouldReadShoppingList(String item, Integer price) {
        assertThat(price <= 50).isTrue();
        System.out.println(item + " = " + price);
    }
}
