package com.sda.advanced.exceptions.handling;

import java.util.Scanner;

public class DemoTryWithResources {

    public static void main(String[] args) {
        System.out.println("type something");
        regularTryCatch();
        tryWithResources();
    }

    private static void regularTryCatch() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("you typed " + scanner.next());
        } catch (Exception e) {
            // handle exception
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void tryWithResources() {
        // try (resources)
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("you typed " + scanner.next());
        } catch (Exception e) {
            // handle exception
        }
    }
}
