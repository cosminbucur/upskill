package com.sda.solid.interface_segregation.after;

public class ToyPlane implements Toy, Movable, Flyable {

    double price;
    String color;

    @Override
    public void fly() {

    }

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
