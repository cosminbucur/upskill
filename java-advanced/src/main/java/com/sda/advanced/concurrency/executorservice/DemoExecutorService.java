package com.sda.advanced.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutorService {

    public static void main(String[] args) {
        System.out.println("Current thread: " + Thread.currentThread().getName());

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> {
            System.out.println("in task: " + Thread.currentThread().getName());
        };

        System.out.println("submit the task");
        executorService.submit(runnable);

        System.out.println("shutting down");
        executorService.shutdown();
    }
}
