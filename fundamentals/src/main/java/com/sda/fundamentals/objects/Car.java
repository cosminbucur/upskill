package com.sda.fundamentals.objects;

public class Car {

    // fields / state
    private String color;
    private int maxSpeed;   // 0
    private String brand;   // null

    public Car() {

    }

    // methods / behavior
    public void drive() {
        System.out.println("driving...");
    }

    // state methods

    // getter
    public int getMaxSpeed() {
        return maxSpeed;
    }

    // setter
    void setMaxSpeed(int newSpeed) {
        maxSpeed = newSpeed;
    }

    public String getBrand() {

        return brand;
    }


}
