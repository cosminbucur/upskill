package com.sda.advanced.collections.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoComparable {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car audi = new Car(2018);
        Car bmw = new Car(2019);
        Car bugatti = new Car(2017);

        cars.add(audi);
        cars.add(bmw);
        cars.add(bugatti);

        print(cars);
        // sort by fabrication year
        Collections.sort(cars);
        System.out.println("======");
        print(cars);
        int result = audi.compareTo(bmw);
    }

    private static void print(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
