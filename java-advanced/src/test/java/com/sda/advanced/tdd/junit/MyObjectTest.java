package com.sda.advanced.tdd.junit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyObjectTest {

    // junit 5
    @Test
    void methodUnderTest() {
        // given
        MyObject myObject = new MyObject();
        String expected = "is working";

        // when
        String actual = myObject.methodUnderTest();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}