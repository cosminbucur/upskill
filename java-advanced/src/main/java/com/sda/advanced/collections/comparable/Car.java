package com.sda.advanced.collections.comparable;

public class Car implements Comparable<Car> {

    private int fabricationYear;

    public Car(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    @Override
    public int compareTo(Car otherCar) {
        return otherCar.fabricationYear - this.fabricationYear;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fabricationYear=" + fabricationYear +
                '}';
    }
}
