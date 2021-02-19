package com.sda.advanced.functional.interfaces.functions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class DemoBiFunction {

    public static void main(String[] args) {
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("john", 40000);
        salaries.put("fredy", 30000);
        salaries.put("anna", 50000);

        // increase by 10000 all salaries except fredy
        BiFunction<String, Integer, Integer> biFunction =
//                (name, oldSalary) -> {
//                    if (name.equals("fredy")) {
//                        return oldSalary;
//                    }
//                    return oldSalary + 10000;
//                };
                (name, oldSalary) -> name.equals("fredy") ? oldSalary : oldSalary + 10000;

        salaries.replaceAll(biFunction);

        salaries.forEach((name, salary) -> System.out.println(name + " - " + salary));
    }
}
