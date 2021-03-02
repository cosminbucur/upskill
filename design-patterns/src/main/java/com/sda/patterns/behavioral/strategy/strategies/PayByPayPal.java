package com.sda.patterns.behavioral.strategy.strategies;

import java.util.Map;

public class PayByPayPal implements PayStrategy {

    private static final Map<String, String> DATABASE = Map.of(
            "alex@gmail.com", "secret",
            "ana@gmail.com", "password"
    );
    private String email;
    private String password;
    private boolean signedIn;

    @Override
    public void collectPaymentDetails() {
        //
    }

    @Override
    public boolean pay(int paymentAmount) {
        System.out.println("paying " + paymentAmount + " using pay pal");
        return true;
    }

    public boolean verify() {
        // check that email matches password

        // if true -> set signedIn
        return true;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
