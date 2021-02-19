package com.sda.advanced.functional.interfaces.consumers;

import java.util.List;
import java.util.function.Consumer;

public class DemoConsumers {

    public static void main(String[] args) {
        // generic input => no return
        Consumer<String> consumer = name -> System.out.println("Hello " + name);

        List<String> names = List.of("ana", "alex", "cristi");
        names.forEach(consumer);

        names.forEach(name -> System.out.println("Hello " + name));
    }
}
