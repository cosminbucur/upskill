package com.sda.advanced.exceptions.errors_vs_exception;

public class StackOverflow {

    // recursion
    public static void work(int i) {
        if (i == 0) {
            System.out.println("ok");
        } else {
            work(i++);
        }
    }
}

// work(1)
// work(2)...