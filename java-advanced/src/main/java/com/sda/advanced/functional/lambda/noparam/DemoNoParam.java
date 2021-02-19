package com.sda.advanced.functional.lambda.noparam;

public class DemoNoParam {

    public static void main(String[] args) {
        // interface = implementation
        NoParam noParam = () -> {
            System.out.println("in lambda body");
            return "cosmin";
        };

        NoParam noParam1 = () -> "alex";

        String myString = noParam.doNothing();
        String otherString = noParam1.doNothing();

        System.out.println(myString);
        System.out.println(otherString);
    }
}
