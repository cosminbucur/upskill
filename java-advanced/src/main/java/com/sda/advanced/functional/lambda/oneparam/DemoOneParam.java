package com.sda.advanced.functional.lambda.oneparam;

public class DemoOneParam {

    public static void main(String[] args) {
        OneParam oneParam = (int someNumber) -> complexOperation(someNumber);
        int result = oneParam.doSomething(3);
        System.out.println(result);
    }

    private static int complexOperation(int someNumber) {
        System.out.println("hello");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        return 5 + someNumber;
    }
}
