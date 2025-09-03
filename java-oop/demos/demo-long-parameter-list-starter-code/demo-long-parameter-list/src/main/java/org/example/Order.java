package org.example;

import java.util.List;

public class Order {
    List<Item> items;
    double taxRate;
    double discountRate;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItems()

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
