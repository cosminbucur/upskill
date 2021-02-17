package com.sda.fundamentals.objects;

public class DemoObjects {

    public static void main(String[] args) {

        // type reference = constructor
        Car myCar = new Car();
        myCar.setMaxSpeed(150);

        myCar.drive();
        String brandOfMyCar = myCar.getBrand();
        System.out.println(brandOfMyCar);
        System.out.println("speed: " + myCar.getMaxSpeed());

        Car myCar2 = new Car();
        myCar2.drive();
        System.out.println("myCar2 speed: " + myCar2.getMaxSpeed());

        Car thirdCar = null;
        System.out.println(thirdCar);
    }
}
