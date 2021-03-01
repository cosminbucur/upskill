package com.sda.patterns.structural.decorator;

public class Scanner extends RobotDecorator {

    private Robot robot;

    public Scanner(Robot robot) {
        this.robot = robot;
    }

    @Override
    protected int cost() {
        return robot.cost() + 10;
    }

    @Override
    public String getInfo() {
        return robot.getInfo() + ", scanner";
    }
}
