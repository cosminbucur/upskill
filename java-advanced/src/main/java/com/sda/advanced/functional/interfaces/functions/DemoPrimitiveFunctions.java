package com.sda.advanced.functional.interfaces.functions;

import java.util.function.IntToDoubleFunction;

public class DemoPrimitiveFunctions {

    public static void main(String[] args) {
        IntToDoubleFunction function = number -> number * number;
        double doubleResult = function.applyAsDouble(10);
    }
}
