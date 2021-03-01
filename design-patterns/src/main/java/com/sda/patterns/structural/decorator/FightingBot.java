package com.sda.patterns.structural.decorator;

public class FightingBot extends Robot {

    public FightingBot() {
        info = "fighting bot";
    }

    @Override
    protected int cost() {
        return 300;
    }
}
