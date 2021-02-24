package com.sda.advanced.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class DemoCallableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask[] randomNumberTasks = new FutureTask[5];

        // task1 -> future1, task2 -> future2
        for (int i = 0; i < 5; i++) {
            Callable<Integer> callable = new RandomGeneratorTask();

            randomNumberTasks[i] = new FutureTask(callable);

            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(randomNumberTasks[i].get());
        }
    }
}
