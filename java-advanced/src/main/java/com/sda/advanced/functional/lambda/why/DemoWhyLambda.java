package com.sda.advanced.functional.lambda.why;

public class DemoWhyLambda {

    public static void main(String[] args) {

        withoutLambda();
    }

    private static void withoutLambda() {
        Cleanable cleanable = new Cleanable() {
            // anonymous implementation
            @Override
            public void clean() {
                System.out.println("hello");
            }
        };

        cleanable.clean();
    }

    private static void withLambda() {
        // anonymous implementation
        Cleanable cleanable = () -> System.out.println("washing");

        cleanable.clean();
    }
}
