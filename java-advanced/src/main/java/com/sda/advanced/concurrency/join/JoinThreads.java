package com.sda.advanced.concurrency.join;

public class JoinThreads implements Runnable {

    @Override
    public void run() {
        System.out.println(System.nanoTime() + " Current thread: " + Thread.currentThread().getName() + " START");

        if (Thread.currentThread().getName().equals("T1")) {

            try {
                System.out.println(System.nanoTime() + " inside join condition");
                DemoJoin.t2.start();
                DemoJoin.t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.nanoTime() + " Current thread: " + Thread.currentThread().getName() + " END");
    }
}
