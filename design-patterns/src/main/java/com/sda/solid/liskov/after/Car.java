package com.sda.solid.liskov.after;

public class Car extends DeviceWithEngine {

    @Override
    void startEngine() {
        System.out.println("car started");
    }
}
