package com.sda.advanced.exceptions.errors_vs_exception;

public class DemoException {

    public static void main(String[] args) {
//        System.out.println(useNullPointerException(2));
//
//        Integer fakeNumber = null;
//        System.out.println(useNullPointerException(fakeNumber));

        useArithmeticException();
    }

    private static int useNullPointerException(Integer number) {
        // compare number to 1
        // compareTo (from Object)
        return number.compareTo(1);
    }

    private static void useArithmeticException() {
        int a = 5;
        int b = 0;

        try {
            int division = a / b;
            System.out.println(division);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
