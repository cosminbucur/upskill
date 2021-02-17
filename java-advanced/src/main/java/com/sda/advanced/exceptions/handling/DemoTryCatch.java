package com.sda.advanced.exceptions.handling;

public class DemoTryCatch {

    public static void main(String[] args) {
//        tryCatch();
        multipleCatch();
    }

    private static void tryCatch() {
        try {
            int x = 5 / 2;
        } catch (Exception e) {
            System.out.println("exception caught and handled");
        } finally {
            System.out.println("no matter what");
        }
    }

    private static void multipleCatch() {
        int[] intArray = {8, 6, 4};
        int y = 2;
        try {
            int x = intArray[3] / y;
        } catch (ArithmeticException e) {
            System.out.println("arithmetic");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("out of bounds");
        } catch (Exception e){
            System.out.println("any other exception");
        }
    }

    private static void catchMultipleTypes() {
        int[] intArray = {8, 6, 4};
        int y = 2;
        try {
            int x = intArray[3] / y;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("arithmetic");
        }
    }

}
