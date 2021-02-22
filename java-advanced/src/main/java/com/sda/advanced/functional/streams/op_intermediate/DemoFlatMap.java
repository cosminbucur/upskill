package com.sda.advanced.functional.streams.op_intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoFlatMap {

    public static void main(String[] args) {
        List<Integer> evens = Arrays.asList(2, 4, 6);            // Stream<Integer>
        List<Integer> odds = Arrays.asList(3, 5, 7);             // Stream<Integer>
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11);    // Stream<Integer>

        Stream<List<Integer>> numbers = Stream.of(evens, odds, primes);
        numbers
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
    }
}
