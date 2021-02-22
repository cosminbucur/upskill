package com.sda.advanced.functional.interfaces.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class DemoUnaryOperator {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                10, 20, 30, 40, 50
        );

        UnaryOperator<Integer> unaryOperator = (number) -> number * number;

        useUnaryOperator(numbers, unaryOperator);
    }

    private static List<Integer> useUnaryOperator(List<Integer> list, UnaryOperator<Integer> operator) {
        List<Integer> result = new ArrayList<>();
        list.forEach(number -> result.add(operator.apply(number)));
        return result;
    }
}
