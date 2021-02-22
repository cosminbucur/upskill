package com.sda.advanced.functional.method_reference.static1;

public class Darius {

    static int hp = 100;

    public static int healUp(int amount) {
        return hp += amount;
    }

    public static int dealDmg(int attackDamage, int trueDamage) {
        return attackDamage + trueDamage;
    }
}
