package com.sda.solid.interface_segregation.after;

public class ToyCar implements Movable, Toy {

    double price;
    String color;

    @Override
    public void move() {

    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public void setColor(String color) {

    }
}
