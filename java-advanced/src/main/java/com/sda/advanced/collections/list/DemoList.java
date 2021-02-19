package com.sda.advanced.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoList {

    public static void main(String[] args) {
        List<String> listOfCountries = createListOfCountries();
        listOperations(listOfCountries);
    }

    private static List<String> createListOfCountries() {
        List<String> listOfCountries = new ArrayList<>();

        // create
        listOfCountries.add("Romania"); // 0
        listOfCountries.add("Italia");  // 1
        listOfCountries.add("Franta");
        listOfCountries.add("Germania");
        listOfCountries.add("Romania");
        return listOfCountries;
    }

    private static void listOperations(List<String> countries) {
        // read
        System.out.println(countries.get(1));
        System.out.println(countries.indexOf("Romania"));

        // update
        countries.set(2, "Rusia");

        // delete
        String countryToDelete = "Germania";

        if (countries.contains(countryToDelete)) {
            countries.remove(countryToDelete);
        } else {
            throw new RuntimeException(countryToDelete + " is not in the list");
        }

        System.out.println(countries.size());

        for (String item : countries) {
            System.out.println(item);
        }

        // create using List.of
        List<String> numbers = List.of("one", "two", "three");
        List<String> numbers2 = Arrays.asList("one", "two", "three");
    }
}
