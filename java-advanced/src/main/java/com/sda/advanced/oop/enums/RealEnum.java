package com.sda.advanced.oop.enums;

public class RealEnum {

    public static void main(String[] args) {
        Hero fighter = new Hero(200, Role.FIGHTER);
        Hero archer = new Hero(100, Role.ARCHER);
        Hero assassin = new Hero(50, Role.ASSASSIN);

        // get role
        System.out.println(assassin.getRole());

        System.out.println(Role.ARCHER.name());
        System.out.println(Role.ARCHER.getDescription());

    }

    // attack based on type
    private static void attack(Hero hero) {
        Role role = hero.getRole();
        switch (role) {
            case ARCHER:
                System.out.println("arrow fired");
                break;
            case FIGHTER:
                System.out.println("sword slash");
                break;
            case ASSASSIN:
                System.out.println("poison released");
                break;
        }

    }
}
