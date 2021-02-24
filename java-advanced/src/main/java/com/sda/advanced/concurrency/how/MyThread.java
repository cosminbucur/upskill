package com.sda.advanced.concurrency.how;

public class MyThread extends Thread {

    private boolean flag = true;

    public void stopRunning() {
        flag = false;
    }

    @Override
    public void run() {
        // print thread name
        System.out.println(Thread.currentThread().getName());

        while (flag) {
            System.out.println("I am running");
        }

        System.out.println("stopped running");
    }
}
