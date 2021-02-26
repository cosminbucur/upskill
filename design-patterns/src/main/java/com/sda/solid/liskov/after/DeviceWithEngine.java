package com.sda.solid.liskov.after;

public class DeviceWithEngine extends TransportationDevice {

    private Engine engine;

    void startEngine() {
        System.out.println("default start");
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
