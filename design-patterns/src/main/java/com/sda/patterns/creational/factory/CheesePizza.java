package com.sda.patterns.creational.factory;

public class CheesePizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("cheese pizza ingredients");
    }
}
