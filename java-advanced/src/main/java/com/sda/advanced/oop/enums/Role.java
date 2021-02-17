package com.sda.advanced.oop.enums;

public enum Role {

    FIGHTER("sword ready"),
    ASSASSIN("dagger ready"),
    ARCHER("arrow ready");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // from Object
    @Override
    public String toString() {
        return "hero: " + description;
    }

}
