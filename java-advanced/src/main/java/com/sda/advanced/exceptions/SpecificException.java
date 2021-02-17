package com.sda.advanced.exceptions;

public class SpecificException {

    public static void main(String[] args) {
    }

    public void right() throws IllegalArgumentException, IllegalStateException {
        businessLogic();
    }

    public void wrong() throws Exception {
        businessLogic();
    }

    private void businessLogic() {
        System.out.println("breakable logic");
    }
}
