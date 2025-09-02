package org.example;

public class Tax {
    double taxRate;

    // getters and setters
    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    // methods
    public double applyTaxRate(double shoppingCart, double taxRate) {
            double tax = (shoppingCart) * taxRate;
            return shoppingCart + tax;
    }
}

