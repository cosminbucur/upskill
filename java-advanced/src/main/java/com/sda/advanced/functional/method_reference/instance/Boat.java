package com.sda.advanced.functional.method_reference.instance;

public class Boat {

    private String color;
    private Integer length;

    public Boat(String color, int length) {
        this.color = color;
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
