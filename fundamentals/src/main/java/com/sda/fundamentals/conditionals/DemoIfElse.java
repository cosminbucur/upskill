package com.sda.fundamentals.conditionals;

// CTRL + scroll up / down
public class DemoIfElse {

    public static void main(String[] args) {
        int account = 1000;

        // if else
        if (account > 1_000_000) {
            System.out.println("you are a mason!");
        } else {
            System.out.println("you are a pawn");
        }

        // multiple if statements
        int age = 18;

        if (age >= 67) {
            System.out.println("you are rich");
        } else if (age >= 18) {
            System.out.println("get a job, get married");
        } else {
            System.out.println("go to school");
        }

        // ternary operator
        String result = age >= 18 ? "adult" : "minor";
        System.out.println(result);
    }
}
