package com.sda.advanced.functional.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class DemoStream {

    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();

        // of
        Stream<String> letters = Stream.of("a", "b", "c");

        // from array
        String[] array = new String[]{"a", "b", "c"};
        Stream<String> streamFromArray = Arrays.stream(array);

        // stream builder
        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
    }
}
