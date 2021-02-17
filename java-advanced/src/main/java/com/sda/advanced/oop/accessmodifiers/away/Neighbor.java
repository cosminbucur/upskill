package com.sda.advanced.oop.accessmodifiers.away;

import com.sda.advanced.oop.accessmodifiers.home.Parent;

public class Neighbor {
    public void hasAccessTo() {
        Parent parent = new Parent();
        System.out.println("public" + parent.phoneNumber);
    }

}
