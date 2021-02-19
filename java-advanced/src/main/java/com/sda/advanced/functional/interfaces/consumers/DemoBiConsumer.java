package com.sda.advanced.functional.interfaces.consumers;

import java.util.Map;

public class DemoBiConsumer {

    public static void main(String[] args) {
        Map<String, Integer> ages = Map.of(
                "ana", 25,
                "alex", 24,
                "cristi", 30
        );

        ages.forEach((name, age) -> System.out.println(name + " is " + age));
    }
}
