package com.sda.advanced.tdd.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int add(String text) {
        if (text.isEmpty()) {
            // empty
            return 0;
        } else if (text.contains(",")) {                      // "1,2"
            // multiple numbers
            List<Integer> numbers = getNumbers(text);
            long negatives = getNegatives(numbers);
            if (negatives > 0) {
                throw new IllegalArgumentException("negative number not supported");
            }

            return sumNumbers(numbers);
        } else {
            // single number
            return toInt(text);
        }
    }

    private static long getNegatives(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number < 0)
                .count();
    }

    private static List<Integer> getNumbers(String text) {
        String[] tokens = text.split(",|\n");          // [1 , 2]
        return Arrays.stream(tokens)
                .map(string -> toInt(string))
                .collect(Collectors.toList());
    }

    private static int sumNumbers(List<Integer> numbers) {
        int result = 0;
        return numbers.stream()
                .mapToInt(integer -> result + integer)
                .sum();
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
}
