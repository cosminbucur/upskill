package com.sda.patterns.behavioral.strategy;

import com.sda.patterns.behavioral.strategy.order.Order;
import com.sda.patterns.behavioral.strategy.strategies.PayByCreditCard;
import com.sda.patterns.behavioral.strategy.strategies.PayByPayPal;
import com.sda.patterns.behavioral.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class DemoStrategyPattern {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static PayStrategy payStrategy;
    private static Order order = new Order();

    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> priceOnProducts = Map.of(
                1, 2200,
                2, 1850,
                3, 1100,
                4, 890
        );

        while (!order.isClosed()) {
            String continueSearch;
            do {
                // build menu
                System.out.println("Select a product:");
                System.out.println("1. Mother board");
                System.out.println("2. CPU");
                System.out.println("3. HDD");
                System.out.println("4. RAM");

                // read input
                int selectedProduct = Integer.parseInt(READER.readLine());
                int cost = priceOnProducts.get(selectedProduct);

                System.out.println("How many?");
                int count = Integer.parseInt(READER.readLine());
                order.setTotalCost(cost * count);

                System.out.println("continue buying? Y/N");
                continueSearch = READER.readLine();
            } while (continueSearch.equalsIgnoreCase("y"));

            // apply strategy
            if (payStrategy == null) {
                System.out.println("please select strategy");
                System.out.println("1. Credit card");
                System.out.println("2. Pay pal");

                int selectedStrategy = Integer.parseInt(READER.readLine());
                if (selectedStrategy == 1) {
                    payStrategy = new PayByCreditCard();
                } else {
                    payStrategy = new PayByPayPal();
                }
            }

            // process order
            order.processOrder(payStrategy);

            System.out.println("pay " + order.getTotalCost() + ". continue shopping?");
            System.out.println("1. Pay");
            System.out.println("2. Cancel");

            int proceed = Integer.parseInt(READER.readLine());
            if (proceed == 1) {
                boolean paymentCompleted = payStrategy.pay(order.getTotalCost());

                if (paymentCompleted) {
                    System.out.println("payment success");
                } else {
                    System.out.println("payment failed");
                }
            }
            order.setClosed();
        }
    }
}
