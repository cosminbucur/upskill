package com.sda.advanced.tdd.junit;

public class UtilityClass {

    public static boolean isDivisibleByThree(int number) {
        return number % 3 == 0;
    }

    public static boolean parseString(String text) {
        return text == null || text.trim().isEmpty();
    }
}
