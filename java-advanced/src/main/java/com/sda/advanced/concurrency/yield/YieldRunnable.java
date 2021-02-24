package com.sda.advanced.concurrency.yield;

public class YieldRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("current thread " + Thread.currentThread().getName() + " priority " + Thread.currentThread().getPriority() + " START");

        // allow thread with same priority to run
        Thread.yield();

        System.out.println("current thread " + Thread.currentThread().getName() + " priority " + Thread.currentThread().getPriority() + " END");
    }
}
