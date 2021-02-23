package com.sda.advanced.optional;

import java.util.Optional;

public class DemoOptional {

    public static void main(String[] args) {
        String value = "MALE";
        Optional<String> optional = Optional.of(value);

        System.out.println("optional non empty" + optional);
        System.out.println("optional value" + optional.get());
        System.out.println("optional empty" + Optional.empty());

    }
}
