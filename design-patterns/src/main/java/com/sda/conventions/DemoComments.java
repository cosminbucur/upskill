package com.sda.conventions;

// not recommended
/*
    This class performs this operation
 */

// ok

/**
 * This class performs this operation
 */
public class DemoComments {

    /**
     * Converts a string to an int.
     *
     * @param variable the string that will be converted. Must not be negative
     * @return the converted int
     */
    public int doSomePublicWork(String variable) {
        return Integer.parseInt(variable);
    }

    // avoid comments that explain code
    private int somePrivateMethod() {
        return 1;
    }

    private void explainBooleanExpressions() {
        int age = 18;
        boolean isMinor = age < 18;

        if (isMinor) {
            System.out.println("you are minor");
        }
    }
}
