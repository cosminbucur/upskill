package com.sda.advanced.collections.generics;

import java.util.ArrayList;
import java.util.List;

public class DemoWhyGenerics {

    public static void main(String[] args) {
        List list = new ArrayList();    // 0, 1, 2...
        list.add("hello");

        List listOfInteger = new ArrayList();
        listOfInteger.add(1);
        listOfInteger.add(2);
        listOfInteger.add("hello");

        for (Object integer : listOfInteger) {
            int squaredInteger;

            try {
                // cast -> transform a type to another type Object -> Integer
                squaredInteger = (Integer) integer * (Integer) integer;
                System.out.println(squaredInteger);
            } catch (Exception e) {
                System.out.println(integer + " is not an integer");
            }
        }
    }
}
