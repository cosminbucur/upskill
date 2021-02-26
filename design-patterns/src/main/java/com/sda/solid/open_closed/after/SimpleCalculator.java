package com.sda.solid.open_closed.after;

public class SimpleCalculator implements ICalculator {

    @Override
    public void calculate(IOperation operation) {
        // break early
        if (operation == null) {
            throw new IllegalArgumentException("some message");
        }

        operation.performOperation();
    }

}
