package com.sda.advanced.functional.streams.op_intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoMap {

    public static void main(String[] args) {
        List<String> loseWeight = new ArrayList<>();
        loseWeight.add("avocados");
        loseWeight.add("beans");
        loseWeight.add("salad");
        loseWeight.add("oats");
        loseWeight.add("broccoli");

        // string -> number of letters
        List<Integer> letterCount = loseWeight.stream()
                .map(food -> food.length())
                .collect(Collectors.toList());

        System.out.println(letterCount);

        // Collectors - utility class
    }
}
