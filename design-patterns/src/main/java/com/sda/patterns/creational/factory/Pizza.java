package com.sda.patterns.creational.factory;

public abstract class Pizza {

    public abstract void addIngredients();

    public void bakePizza() {
        System.out.println("baked at 180 degree");
    }
}
