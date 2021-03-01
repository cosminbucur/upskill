package com.sda.patterns.creational.factory;

public class PizzaFactory extends BasePizzaFactory {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "veggie":
                pizza = new VeggiePizza();
                break;
            default:
                throw new IllegalArgumentException("no such pizza");
        }

        pizza.addIngredients();
        pizza.bakePizza();
        return pizza;
    }
}
