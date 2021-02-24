package com.sda.advanced.concurrency.deadlock.problem;

public class DemoDeadLockProblem {

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();

        // Thread-1
        Runnable task1 = () -> {
            synchronized (a) {
                try {
                    // both threads running
                    // Adding delay so that both threads can start trying to
                    // lock resources
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread-1 have A but need B also
                synchronized (b) {
                    System.out.println("In block 1");
                }
            }
        };

        // Thread-2
        Runnable task2 = () -> {
            synchronized (b) {
                // Thread-2 have B but need A also
                synchronized (a) {
                    System.out.println("In block 2");
                }
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
