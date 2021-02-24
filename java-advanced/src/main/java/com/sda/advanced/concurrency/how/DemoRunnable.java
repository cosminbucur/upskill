package com.sda.advanced.concurrency.how;

import java.util.Arrays;
import java.util.List;

public class DemoRunnable {

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("running");
        Thread worker = new Thread(task);
        worker.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        };

        // runnable with lambda
        Runnable greetingRunnable = () -> System.out.println("hello from runnable");
        Thread thread1 = new Thread(greetingRunnable);

        List<String> names = Arrays.asList("ana", "alex", "sorin");
        Runnable printNames = () -> {
            System.out.println("in runnable");
            names.forEach(name -> System.out.println(name));
        };

        Thread thread2 = new Thread(printNames);

        thread1.start();
        thread2.start();
    }
}
