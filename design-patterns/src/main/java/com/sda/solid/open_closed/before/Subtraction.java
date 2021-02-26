package com.sda.solid.open_closed.before;

public class Subtraction implements IOperation {

    private int first;
    private int second;
    private int result;

    public Subtraction(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
