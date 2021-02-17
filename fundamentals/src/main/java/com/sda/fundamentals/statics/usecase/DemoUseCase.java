package com.sda.fundamentals.statics.usecase;


import static com.sda.fundamentals.statics.usecase.Constants.NOT_FOUND;
import static com.sda.fundamentals.statics.usecase.Constants.SAVED;
import static com.sda.fundamentals.statics.usecase.Constants.DELETED;

// camel case
public class DemoUseCase {

    public static void main(String[] args) {
        useStaticConstants();
        useStaticImport();
    }

    public static void useStaticConstants() {
        System.out.println(SAVED);
        System.out.println(DELETED);
    }

    public static void useStaticImport() {
        System.out.println(NOT_FOUND);
    }

}
