package com.sda.advanced.concurrency.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoFutureCancel {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "hello from callable";
        });

        while (!future.isDone()) {
            System.out.println("task is not not done...");
            Thread.sleep(200);
            // elapsed time
            double elapsedTimeInSeconds = (System.nanoTime() - startTime) / 1000000000.0;

            if (elapsedTimeInSeconds > 1) {
                future.cancel(true);
            }
        }

        if (future.isCancelled()) {
            System.out.println("task was canceled");
        } else {
            System.out.println("task completed! getting result");
            String result = future.get();
            System.out.println(result);
        }

        executorService.shutdown();
    }
}
