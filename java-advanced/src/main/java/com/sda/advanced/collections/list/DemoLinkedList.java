package com.sda.advanced.collections.list;

import java.util.LinkedList;
import java.util.List;

public class DemoLinkedList {

    public static void main(String[] args) {
        List<Customer> customers = new LinkedList<>();

        Customer ana = new Customer("Ana");
        Customer alex = new Customer("Alex");
        Customer anto = new Customer("Anto");

        customers.add(ana);
        customers.add(alex);
        customers.add(anto);

        customers.get(0);

        customers.set(0, new Customer("Paul"));

        customers.remove(0);
        customers.remove(alex);

        System.out.println(customers.size());
    }
}
