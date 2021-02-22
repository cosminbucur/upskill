package com.sda.advanced.functional.method_reference.instance_arbitrary;

import java.util.Arrays;
import java.util.List;

public class DemoInstanceArbitrary {

    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(9, 5, 7, 6, 8);

        grades.stream()
                .sorted((first, second) -> first.compareTo(second))
                .forEach(grade -> System.out.println(grade));

        grades.stream()
                .sorted(Integer::compareTo)
                // class :: method
                .forEach(System.out::println);

    }
}
