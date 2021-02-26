package com.sda.solid.liskov.after;

public class Bike extends DeviceWithoutEngine {

    @Override
    public void startMoving() {
        System.out.println("cycling...");
    }
}
