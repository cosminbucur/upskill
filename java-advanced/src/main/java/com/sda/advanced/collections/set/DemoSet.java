package com.sda.advanced.collections.set;

import java.util.Set;
import java.util.TreeSet;

public class DemoSet {

    public static void main(String[] args) {
        Set<String> cities = new TreeSet<>();

        cities.add("Madrid");
        cities.add("Berlin");
        cities.add("Roma");
        cities.add("Paris");

        cities.remove("Paris");

        for (String city : cities) {
            System.out.println(city);
        }
    }
}
