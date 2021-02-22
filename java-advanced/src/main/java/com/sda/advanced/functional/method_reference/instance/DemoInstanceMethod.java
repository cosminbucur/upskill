package com.sda.advanced.functional.method_reference.instance;

import java.util.ArrayList;
import java.util.List;

public class DemoInstanceMethod {

    public static void main(String[] args) {
        List<Boat> boats = new ArrayList<>();
        boats.add(new Boat("red", 30));
        boats.add(new Boat("green", 50));
        boats.add(new Boat("blue", 20));

        BoatComparator customComparator = new BoatComparator();

        // qualifier
        boats.stream()
                .sorted(customComparator);

        // lambda
        boats.stream()
                .sorted((first, second) -> customComparator.compare(first, second));

        // method reference
        boats.stream()
                .sorted(customComparator::compare);

        boats.stream()
                .sorted(new BoatComparator()::compare);
    }
}
