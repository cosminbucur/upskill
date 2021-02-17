package com.sda.advanced.collections.generics;

public class DemoGeneric {

    public static void main(String[] args) {
        ToyCar toyCar = new ToyCar();
        GenericBox<ToyCar> boxOfCars = new GenericBox<>(toyCar);
        ToyCar toyCar1 = new ToyCar();
        boxOfCars.add(toyCar1);
    }
}
