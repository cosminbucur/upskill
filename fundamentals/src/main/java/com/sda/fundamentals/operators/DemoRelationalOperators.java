package com.sda.fundamentals.operators;

public class DemoRelationalOperators {


    public static void main(String[] args) {
        // equality
        int a = 5;
        int b = 6;

        boolean result = a == b;
        System.out.println(result);     // false

        // different
        System.out.println(a != b);     // true

        // greater
        System.out.println(a > b);      // false
        System.out.println(a >= b);      // false

        // lesser
        int c = 4;
        int d = 4;
        System.out.println(c < d);      // false
        System.out.println(c <= d);      // true
    }
}
