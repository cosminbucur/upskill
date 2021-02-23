package com.sda.advanced.optional.how;

import java.util.Optional;

public class DemoRealOptional {

    public static void main(String[] args) {
        Database database = new Database();

        Optional<Person> paul = database.findPersonByName("alex");
        if (paul.isPresent()) {
            System.out.println(paul.get());
        }
        System.out.println(paul);

        Person foundPerson = database.findPersonByName("cristi")
                .orElseThrow(() -> new RuntimeException("person not found"));
        System.out.println(foundPerson);
    }
}
