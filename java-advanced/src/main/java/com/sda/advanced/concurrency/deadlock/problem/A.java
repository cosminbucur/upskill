package com.sda.advanced.concurrency.deadlock.problem;

public class A {
    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}