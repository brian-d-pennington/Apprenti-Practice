package org.example;

public class ShoppingCart {
    public double checkoutShoppingCart (Item[] items) {
        // method now only returns items and their prices
        double subtotal = 0.00;
        for (int i = 0; i < items.length; i++) {
            subtotal += items[i].getPrice();
        }

        return subtotal;
    }
}
