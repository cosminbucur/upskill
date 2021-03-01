package com.sda.patterns.structural.facade;

public class OrderServiceFacadeImpl implements OrderServiceFacade {

    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;

    public OrderServiceFacadeImpl(InventoryService inventoryService, PaymentService paymentService, ShippingService shippingService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
    }

    @Override
    public boolean placeOrder(long productId) {
        Product product = new Product();
        boolean orderCompleted = false;
        if (inventoryService.isAvailable(product)) {
            System.out.println("product with id " + product.productId + " is available");

            boolean paymentConfirmed = paymentService.makePayment();

            if (paymentConfirmed) {
                System.out.println("payment confirmed");

                shippingService.shipProduct(product);
                System.out.println("product shipped...");

                orderCompleted = true;
            }
        }
        return orderCompleted;
    }
}
