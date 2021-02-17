package com.sda.fundamentals.variables;

public class RealVariables {

    public static void main(String[] args) {
        int myAge = 30;

        // https://www.epochconverter.com/
        long timestamp = 1613406898L;

        // normally use BigDecimal
        double price = 20.5;

        boolean isActive = true;

        char firstLetter = 'a';

        char tab = '\t';

        System.out.println(myAge);

        // age ---- timestamp
        System.out.println(myAge + ":" + tab + ":" + timestamp);
    }
}
