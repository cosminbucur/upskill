package com.sda.advanced.functional.interfaces.suppliers;

import java.time.LocalDate;
import java.util.function.Supplier;

public class DemoSupplier {

    public static void main(String[] args) {
        // no input => return
        Supplier<LocalDate> dateSupplier = () -> LocalDate.now();
        System.out.println(dateSupplier.get());

        Supplier<Throwable> exceptionSupplier = () -> new RuntimeException("message");
        exceptionSupplier.get();
    }
}
