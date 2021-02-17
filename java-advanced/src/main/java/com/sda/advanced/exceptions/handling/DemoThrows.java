package com.sda.advanced.exceptions.handling;

public class DemoThrows {

    public static void main(String[] args) throws Exception {
        int[] someIntArray = {3, 4, 2};

        printArrayElement(someIntArray, 2);
    }

    private static void printArrayElement(int[] intArray, int index) throws Exception  {
        // fail fast
        if (index < 0 || index >= intArray.length) {
            throw new Exception("Incorrect argument!");
        }
        System.out.println(intArray[index]);
    }
}
