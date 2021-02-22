package com.sda.advanced.functional.streams.op_intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemoFilter {

    public static void main(String[] args) {
        List<String> versions = new ArrayList<>();
        versions.add("Lollipop");
        versions.add("KitKat");
        versions.add("Jelly Bean");
        versions.add("Ice Cream Sandwidth");
        versions.add("Honeycomb");
        versions.add("Gingerbread");

        // letters > 10
        versions.stream()
                .filter(word -> word.length() > 10)
                .forEach(word -> System.out.println(word));

        // first word that has letter E
        System.out.println("find first");
        Optional<String> optional = versions.stream()
                .filter(word -> word.contains("e"))
                .findAny();

        if (optional.isPresent()) {
            String foundWord = optional.get();
            System.out.println(foundWord);
        }

        // length > 5 and starts with G
        System.out.println("multiple ");
        versions.stream()
                .filter(word -> lengthGreaterThan5(word))
                .filter(word -> word.startsWith("G"))
                .forEach(word -> System.out.println(word));
    }

    private static boolean lengthGreaterThan5(String word) {
        return word.length() > 5;
    }
}
