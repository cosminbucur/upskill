package com.sda.demeter;

public class Address {

    private String zipCode;
    private String number;
    private String street;
    private String city;
    private String state;
    private String country;

    public Address(String zipCode, String number, String street, String city, String state, String country) {
        this.zipCode = zipCode;
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
