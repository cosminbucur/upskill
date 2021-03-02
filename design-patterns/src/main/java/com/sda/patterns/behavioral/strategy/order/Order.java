package com.sda.patterns.behavioral.strategy.order;

import com.sda.patterns.behavioral.strategy.strategies.PayStrategy;

public class Order {

    private int totalCost = 0;
    private boolean closed = false;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed() {
        this.closed = true;
    }
}
