package com.sda.demeter;

public class DemoDemeter {

    public static void main(String[] args) {
        Address address = new Address(
                "023445",
                "50",
                "unirii",
                "Bucharest",
                "Bucharest",
                "Romania");
        House house = new House("gray", 20, address);
        Person person = new Person("alex", house);

        // get zipcode
        // tran wreck
        String zipCode = person.getHouse().getAddress().getZipCode();

        // correct approach to law of demeter
        person.getZipCode();
    }
}
