package org.example.inheritanceexercise;

public final class GiftCard extends Payment {
    private String accountNumber;
    private double balance;
    private int loyaltyPointsAccumulated;

    // constructor
    public GiftCard(int id, double amount, String accountNumber, double balance, int loyaltyPointsAccumulated){
        super(id, amount);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.loyaltyPointsAccumulated = loyaltyPointsAccumulated;
    };

    // methods
    @Override
    public boolean processPayment() {
        System.out.println("Processing gift card and adding loyalty points...");
        if (balance >= getAmount()) {
            balance -= getAmount();
            int roundedValue = (int) Math.round(getAmount());
            loyaltyPointsAccumulated = roundedValue * 100;
            System.out.println("Loyalty points: " + loyaltyPointsAccumulated);
            return true;
        } else {
            System.out.println("No loyalty points accrued for this transaction.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Payment:  " + getId() + "  Amount:  $" + String.format("%.2f", getAmount()) + " Payment Type: Gift Card. Balance: " + balance + " Loyalty Points: " + loyaltyPointsAccumulated;
    }
}
