package com.sda.advanced.functional.lambda.towparam;

public class DemoTwoParam {

    public static void main(String[] args) {
        TwoParam twoParam = (String first, String second) ->
                first.concat(second).toUpperCase();

        String result = twoParam.doSomething("paul", "ene");
        System.out.println(result);
    }
}
