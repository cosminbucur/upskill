package com.sda.advanced.exceptions;

public class LogWithoutThrow {

    public static void main(String[] args) {
//        wrongBusinessLogic();

        try {
            beLazy();
        } catch (IllegalStateException e) {
            System.out.println("ERROR " + e);
            System.out.println("handling... carry on");
        }
    }

    public static void beLazy() throws IllegalStateException {
        doBusinessLogic();
    }

    private static void doBusinessLogic() throws IllegalStateException {
        System.out.println("breakable logic");
        throw new IllegalStateException("crappy code");
    }

    private static void wrongBusinessLogic() throws IllegalStateException {
        System.out.println("breakable logic");

        System.out.println("log ERROR: crappy code");
        throw new IllegalStateException("crappy code");
    }
}
