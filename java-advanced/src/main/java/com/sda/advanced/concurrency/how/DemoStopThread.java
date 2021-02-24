package com.sda.advanced.concurrency.how;

public class DemoStopThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.stopRunning();
    }
}
