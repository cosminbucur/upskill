package com.sda.solid.open_closed.before;

public class SimpleCalculator implements ICalculator {

    @Override
    public void calculate(IOperation operation) {
        // break early
        if (operation == null) {
            throw new IllegalArgumentException("some message");
        }

        if (operation instanceof Addition) {
            Addition addition = (Addition) operation;
            addition.setResult(
                    addition.getFirst() + addition.getSecond());
        } else if (operation instanceof Subtraction) {
            Subtraction subtraction = (Subtraction) operation;
            subtraction
                    .setResult(subtraction.getFirst() - subtraction.getSecond());
        }
    }
}
