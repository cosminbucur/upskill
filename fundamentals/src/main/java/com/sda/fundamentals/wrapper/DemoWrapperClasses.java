package com.sda.fundamentals.wrapper;

public class DemoWrapperClasses {

    // boolean, int,....
    // Boolean, Integer, Long, Double

    public static void main(String[] args) {
        Integer integerObject = Integer.valueOf(100);
        System.out.println(integerObject);

        Double doubleObject = Double.valueOf("20.5");
        System.out.println(doubleObject);
    }

    private static void boxingAndUnboxing() {
        int integer = 30;
        // boxing
        Integer boxedInteger = Integer.valueOf(integer);

        // unboxing
        Double boxedDouble = 20.5;  // automatic
        double unboxedDouble = boxedDouble;
    }
}
