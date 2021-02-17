package com.sda.advanced.oop.enums;

public class DemoEnum {

    public static void main(String[] args) {
        Direction direction = Direction.EAST;

        // use enum
        if (direction.equals(Direction.EAST)) {
            System.out.println("going to china");
        }

        // get enum name
        String enumName = Direction.NORTH.name();
        System.out.println(enumName);

        // get enum value from string
        Direction enumValue = Direction.valueOf("SOUTH");
        System.out.println(enumValue);

        // get enum values
        Direction[] values = Direction.values();

        for (Direction item : values) {
            System.out.println(item);
        }
    }
}
