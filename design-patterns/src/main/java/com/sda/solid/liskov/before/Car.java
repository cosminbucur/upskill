package com.sda.solid.liskov.before;

public class Car extends TransportationDevice {

    @Override
    void startEngine() {
        System.out.println("engine started");
    }
}
