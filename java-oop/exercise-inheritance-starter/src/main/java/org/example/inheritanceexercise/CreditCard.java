package org.example.inheritanceexercise;

public final class CreditCard extends Payment {
    // local variables
    private long accountNumber;
    private String cardVendor;

    // constructor
    public CreditCard(int id, double amount, long accountNumber, String cardVendor){
        super(id, amount);
        this.accountNumber = accountNumber;
        this.cardVendor = cardVendor;
    };

    // getters and setters

    public String getCardVendor() {
        return cardVendor;
    }

    public void setCardVendor(String cardVendor) {
        this.cardVendor = cardVendor;
    }

    // methods
    @Override
    public boolean processPayment() {
        System.out.println("Processing via: " + cardVendor + " for $" + getAmount());
        return true;
    }

    @Override
    public String toString() {
        return "Made Payment:  " + processPayment() + "  Amount:  $" + String.format("%.2f", getAmount()) + " Payment Type: Credit Card. Vendor: " + cardVendor;
    }
}