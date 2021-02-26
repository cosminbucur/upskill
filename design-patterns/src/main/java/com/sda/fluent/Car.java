package com.sda.fluent;

public class Car {

    private int fabricationYear;
    private int price;
    private String brand;

    public Car(int fabricationYear, int price, String brand) {
        this.fabricationYear = fabricationYear;
        this.price = price;
        this.brand = brand;
    }

    public Car setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
        return this;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Car setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fabricationYear=" + fabricationYear +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
