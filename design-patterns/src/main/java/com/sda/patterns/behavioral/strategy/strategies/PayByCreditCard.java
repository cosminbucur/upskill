package com.sda.patterns.behavioral.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.println("enter card number:");
            String cardNumber = READER.readLine();
            System.out.println("enter expiration date 'mm/yy");
            String date = READER.readLine();
            System.out.println("enter cvv code");
            String code = READER.readLine();
            card = new CreditCard(cardNumber, date, code);

            // validate information
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("paying " + paymentAmount + " using credit card");
            return true;
        }
        return false;
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
