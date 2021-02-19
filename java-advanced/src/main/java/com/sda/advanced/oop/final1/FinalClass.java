package com.sda.advanced.oop.final1;

// can't be extended
public final class FinalClass {

    // can't be modified
    private static final String CONSTANT = "ceva";

    private final int value;

    public FinalClass(int value) {
        this.value = value;
    }

    // not recommended
    public void transform(final int valueToTransform) {
        System.out.println(valueToTransform);
    }
}
