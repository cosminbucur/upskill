package com.sda.fundamentals.operators;

public class DemoArithmeticOperators {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        int sum = a + b;
        System.out.println(sum);

        // use shortcut to create variable
        // ALT + ENTER (suggest options)
        int subtraction = a - b;
        System.out.println(subtraction);

        int multiply = a * b;
        System.out.println(multiply);

        int division = a / b;
        System.out.println(division);

        // rest after division
        int modulo = 5 % 2; // 1
        System.out.println(modulo);

        // post increment
        int age = 20;
        // age = age + 1;
        System.out.println(age++);          // 20

        // pre increment
        int size = 20;
        System.out.println(++size);         // 21

        // post decrement
        int temperature = 5;
        System.out.println(temperature--);  // 5

        // pre decrement
        int count = 5;
        System.out.println(--count);  // 4
    }
}
