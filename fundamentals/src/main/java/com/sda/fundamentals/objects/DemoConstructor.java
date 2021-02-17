package com.sda.fundamentals.objects;

public class DemoConstructor {

    public static void main(String[] args) {
        Boat boat = new Boat();
        boat.setColor("red");
        boat.setMaxSpeed(200);

        // CTRL + P = show definitions
        Boat boat2 = new Boat("blue", 50);
        System.out.println(boat2.getColor());

        boat = null;
    }
}

class Boat {

    // use private most of the time
    // class member / field
    private String color;
    private int maxSpeed;

    // default constructor
    public Boat() {
        // explicit default constructor when having multiple constructors
    }

    public Boat(String color, int maxSpeed) {
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    // getter
    // var1: alt + insert
    // var2: get + firstLetter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}


