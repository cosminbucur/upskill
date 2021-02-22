package com.sda.advanced.functional.streams.op_terminal;

import java.util.Arrays;
import java.util.List;

public class DemoReduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer sum = numbers.stream()
                .reduce(0, (subtotal, next) -> subtotal + next);
        System.out.println(sum);
    }
}
