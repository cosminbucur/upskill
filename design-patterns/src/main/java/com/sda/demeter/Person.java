package com.sda.demeter;

public class Person {

    private String name;
    private House house;

    public Person(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getZipCode() {
        return house.getZipCode();
    }
}
