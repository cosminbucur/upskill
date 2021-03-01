package com.sda.patterns.structural.decorator;

public class Thrusters extends RobotDecorator {

    private Robot robot;

    public Thrusters(Robot robot) {
        this.robot = robot;
    }

    @Override
    protected int cost() {
        return robot.cost() + 20;
    }

    @Override
    public String getInfo() {
        return robot.getInfo() + ", thrusters";
    }
}
