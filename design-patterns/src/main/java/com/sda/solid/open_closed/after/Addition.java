package com.sda.solid.open_closed.after;

public class Addition implements IOperation {

    private int first;
    private int second;
    private int result;

    public Addition(int first, int second) {
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

    @Override
    public void performOperation() {
        result = first + second;
    }
}
