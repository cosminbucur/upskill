package com.sda.patterns.structural.facade;

public class PaymentService {

    public boolean makePayment() {
        System.out.println("connect with gateway for payment");
        return true;
    }
}
