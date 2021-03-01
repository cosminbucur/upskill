package com.sda.patterns.creational.abstract_factory.button;

public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("paint mac button");
    }
}
