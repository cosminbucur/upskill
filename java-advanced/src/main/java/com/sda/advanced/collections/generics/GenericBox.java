package com.sda.advanced.collections.generics;

// generic class
// <> diamond operator
// T any type of object
public class GenericBox<T> {

    private T car;

    public GenericBox(T car) {
        this.car = car;
    }

    public void add(T toyCar) {
        this.car = toyCar;
    }

}
