package com.sda.advanced.functional.streams.op_terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoForEach {

    public static void main(String[] args) {
        List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "test", "dog"));

        alphabets.stream()
                .filter(word -> word.length() > 2)
                .forEach(word -> System.out.println(word));

        alphabets
                .forEach(word -> System.out.println(word));
    }
}
