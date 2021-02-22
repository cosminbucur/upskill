package com.sda.advanced.functional.interfaces.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

public class DemoBinaryOperator {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "X");
        map.put("B", "Y");
        map.put("C", "Z");

        BinaryOperator<String> binaryOperator = (key, value) -> key + "-" + value;

        System.out.println(useBinaryOperator(map, binaryOperator));
    }

    private static List<String> useBinaryOperator(Map<String, String> map, BinaryOperator<String> operator) {
        List<String> result = new ArrayList<>();
        map.forEach((key, value) -> result.add(operator.apply(key, value)));
        return result;
    }
}
