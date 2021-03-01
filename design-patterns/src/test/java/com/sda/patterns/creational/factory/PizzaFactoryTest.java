package com.sda.patterns.creational.factory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PizzaFactoryTest {

    // client code
    @Test
    void givenCheese_whenCreate_thenReturnCheesePizza() {
        // given
        BasePizzaFactory factory = new PizzaFactory();

        // when
        Pizza actualPizza = factory.createPizza("cheese");

        // then
        assertThat(actualPizza).isInstanceOf(CheesePizza.class);
    }

    @Test
    void givenVeggie_whenCreate_thenReturnVeggiePizza() {
        // given
        BasePizzaFactory factory = new PizzaFactory();

        // when
        Pizza actualPizza = factory.createPizza("veggie");

        // then
        assertThat(actualPizza).isInstanceOf(VeggiePizza.class);
    }
}