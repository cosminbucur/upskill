package com.sda.advanced.functional.interfaces.functions;

import java.util.function.Function;

public class DemoFunctions {

    public static void main(String[] args) {
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        };

        Function<Integer, Integer> multiplyBy2Function = integer -> integer * 2;
        multiplyBy2Function.apply(5);
    }
}
