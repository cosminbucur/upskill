package com.sda.advanced.concurrency;

public class Counter {

    private long count = 0;

    // only one thread at a time can modify count
    public synchronized void add(long value) {
        this.count += value;
    }

    public long getCount() {
        return count;
    }
}
