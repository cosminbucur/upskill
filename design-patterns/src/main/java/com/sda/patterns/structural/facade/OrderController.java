package com.sda.patterns.structural.facade;

public class OrderController {

    private OrderServiceFacade facade;

    public boolean orderProduct(long productId) {
        return facade.placeOrder(productId);
    }
}
