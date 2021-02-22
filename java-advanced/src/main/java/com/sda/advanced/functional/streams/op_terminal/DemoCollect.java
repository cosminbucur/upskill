package com.sda.advanced.functional.streams.op_terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DemoCollect {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("one");
        names.add("two");
        names.add("two");
        names.add("three");

        // uppercase words and return list
        Set<String> upperCaseSet = names.stream()
                .map(string -> string.toUpperCase())
                .peek(string -> System.out.println(string)) // debugging
                .collect(Collectors.toSet());

        System.out.println(upperCaseSet.size());
//        System.out.println(upperCaseSet);
    }
}
