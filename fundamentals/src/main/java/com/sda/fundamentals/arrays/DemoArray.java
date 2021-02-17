package com.sda.fundamentals.arrays;

public class DemoArray {

    public static void main(String[] args) {
        // create

        // type[] name = {elements}
        int[] emptyArray = {};  // length 0
        System.out.println(emptyArray.length);

        int[] arrayWithInitialSize = new int[10];
        System.out.println(arrayWithInitialSize.length);

        System.out.println("cosmin " + arrayWithInitialSize[8]);

                    // 0, 1, 2, 3, 4
        int[] array = {1, 2, 3, 4, 5};

        // read
        int firstNumber = array[0];

        // length = 5
        int lastNumber = array[array.length - 1];

        // update
        arrayWithInitialSize[9] = 100;

        printElementsOfArray(array);
    }

    public static void printElementsOfArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // enhanced for
    public static void printElements(int[] array) {
        // element : collection
        for (int element : array) {
            System.out.println(element);
        }
    }
}
