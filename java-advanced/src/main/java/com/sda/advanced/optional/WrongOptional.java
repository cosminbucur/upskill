package com.sda.advanced.optional;

import java.util.Optional;

public class WrongOptional {

    public static void main(String[] args) {
        Optional<String> myOptional = Optional.ofNullable("test");

        if (myOptional.isPresent()) {
            System.out.println(myOptional.get());
        }
    }
}
