package org.example;

public class Discount {
    double discounted;
    double discountCode;

    // getters & setters
    public double getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(double discountCode) {
        this.discountCode = discountCode;
    }

    // methods
    public double applyDiscount(double shoppingCart, double discountCode) {
        discounted = shoppingCart * discountCode;
        return shoppingCart -= discounted;
    }
}
