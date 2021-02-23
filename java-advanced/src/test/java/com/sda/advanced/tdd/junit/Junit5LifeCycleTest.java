package com.sda.advanced.tdd.junit;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class Junit5LifeCycleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach executed");
    }

    @Test
    void testOne() {
        System.out.println("in test one");
        assertThat(true).isTrue();
    }

    @Test
    void testTwo() {
        System.out.println("in test two");
        assertThat(true).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach executed");
    }
}
