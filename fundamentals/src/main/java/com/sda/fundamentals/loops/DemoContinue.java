package com.sda.fundamentals.loops;

public class DemoContinue {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 2) {
                System.out.println("do this only when 2");
                continue;
            }
            System.out.println("do this every time");
        }
    }
}
