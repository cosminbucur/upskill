package com.sda.fundamentals.methods;

public class DemoMethods {

    public static void main(String[] args) {
        // call method
        printAHardCodedName();

        String name = "alex";
        printAnyName("alex");
        printAnyName(name);

        int returnedResult = sum(2, 3);
        System.out.println(sum(2, 3));
    }

    // print name

    // method definition
    // method signature
    // access modifier | return type | name | parameters
    public static void printAHardCodedName() {
        // method body
        System.out.println("cosmin");
    }

    // pass a parameter
    public static void printAnyName(String name) {
        System.out.println(name);
    }

    // return method
    public static int sum(int first, int second) {
        return first + second;
    }
}
