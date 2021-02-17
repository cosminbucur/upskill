package com.sda.advanced.exceptions;

public class OrderOfExceptions {

    public void handleInOrder() {
        try {
            doBusinessLogic();
        } catch (NumberFormatException e) {

        } catch (IllegalArgumentException e) {

        } catch (Exception e) {

        }
    }


    private void doBusinessLogic() {
        System.out.println("breakable logic");
    }
}
