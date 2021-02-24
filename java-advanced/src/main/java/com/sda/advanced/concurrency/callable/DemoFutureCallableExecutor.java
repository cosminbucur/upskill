package com.sda.advanced.concurrency.callable;

import java.util.concurrent.*;

public class DemoFutureCallableExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            System.out.println("in callable");
            Thread.sleep(2000);
            return "hello from callable";
        };

        System.out.println("submit callable");
        Future<String> futureObject = executorService.submit(task);

        System.out.println("do something else while callable is being executed");

        System.out.println("retrieve the result of the future");

        String result = futureObject.get();
        System.out.println("result: " + result);

        executorService.shutdown();
    }
}
