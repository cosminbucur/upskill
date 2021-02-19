package com.sda.advanced.collections.map;

import java.util.*;

public class DemoMap {

    public static void main(String[] args) {
        Map<String, String> nameAndSurnameMap = new HashMap<>();
        nameAndSurnameMap.put("ana", "vasile");
        nameAndSurnameMap.put("stan", "horia");

        Map<Integer, String> customers = new HashMap<>();
        customers.put(1, "vasile");
        customers.put(2, "horia");

        // name - list of friends
        Map<String, List<String>> network = new HashMap<>();
        network.put("cristi", Arrays.asList("one", "two", "three"));

        // take elements, put them in an array
        // convert array to list
        List<String> stuff = Arrays.asList("one", "two", "three");

        // item : collection
        // entry = key - value pair
        for (Map.Entry<String, String> entry : nameAndSurnameMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        String customerValue = customers.get(1);
        String value = nameAndSurnameMap.get("ana");

        // key set
        Set<Integer> myKeys = customers.keySet();

        // values
        Collection<String> values = customers.values();
    }
}
