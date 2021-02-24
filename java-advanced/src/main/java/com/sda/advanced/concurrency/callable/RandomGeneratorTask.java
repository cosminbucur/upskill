package com.sda.advanced.concurrency.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomGeneratorTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(5);

        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }
}
