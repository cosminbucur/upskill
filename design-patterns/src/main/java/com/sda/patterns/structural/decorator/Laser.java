package com.sda.patterns.structural.decorator;

public class Laser extends RobotDecorator {

    private Robot robot;

    public Laser(Robot robot) {
        this.robot = robot;
    }

    @Override
    protected int cost() {
        return robot.cost() + 50;
    }

    @Override
    public String getInfo() {
        return robot.getInfo() + ", laser";
    }
}
