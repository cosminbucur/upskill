package com.sda.patterns.creational.factory;

public class VeggiePizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("veggie pizza ingredients");
    }
}
