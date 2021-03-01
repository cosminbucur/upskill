package com.sda.patterns.structural.decorator;

public abstract class Robot {

    String info;

    public String getInfo() {
        return info;
    }

    protected abstract int cost();
}
