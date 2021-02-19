package com.sda.advanced.functional.interfaces.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemoPredicate {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

        // input => boolean
        Predicate<String> startsWithAPredicate = name -> name.startsWith("A");
        Predicate<String> startsWithBPredicate = name -> name.startsWith("B");

        List<String> namesWithA = filterNames(names, startsWithAPredicate);
        namesWithA.forEach(name -> System.out.println(name));

        List<String> namesWithB = filterNames(names, startsWithBPredicate);
        namesWithB.forEach(name -> System.out.println(name));
    }

    private static List<String> filterNames(List<String> names, Predicate<String> predicate) {
        return names.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
