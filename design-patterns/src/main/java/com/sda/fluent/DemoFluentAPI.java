package com.sda.fluent;

public class DemoFluentAPI {

    public static void main(String[] args) {
        Car car = new Car(2020, 5000, "ford");

        // update object with fluent api
        car
                .setBrand("audi")
                .setPrice(80000)
                .setFabricationYear(2021);
    }
}
