package com.sda.advanced.oop.accessmodifiers.home;

public class Thief {

    public void hasAccessTo() {
        Parent parent = new Parent();
        System.out.println("public" + parent.phoneNumber);
        System.out.println("protected" + parent.wealth);
        System.out.println("protected" + parent.familyToilet);
    }
}
