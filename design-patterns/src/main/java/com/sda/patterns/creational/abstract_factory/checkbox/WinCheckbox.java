package com.sda.patterns.creational.abstract_factory.checkbox;

public class WinCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("paint windows checkbox");
    }
}
