package com.sda.demeter;

public class House {

    private String color;
    private int size;
    private Address address;

    public House(String color, int size, Address address) {
        this.color = color;
        this.size = size;
        this.address = address;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getZipCode() {
        return address.getZipCode();
    }
}
