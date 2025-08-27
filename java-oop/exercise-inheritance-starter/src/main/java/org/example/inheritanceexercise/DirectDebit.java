package org.example.inheritanceexercise;

public final class DirectDebit extends Payment {
    private long routingNumber;
    private long accountNumber;
    private String bankName;
    private double processingFee;

    // constructor
    public DirectDebit(int id, double amount, long routingNumber, long accountNumber, String bankName, double processingFee) {
        super(id, amount);
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.processingFee = processingFee;
    };

    // methods
    @Override
    public boolean processPayment() {
        System.out.println("Direct debit processing fee: $" + processingFee);
        return true;
    }

    @Override
    public String toString() {
        return "Payment:  " + getId() + "  Amount:  $" + String.format("%.2f", getAmount()) + " Payment Type: Direct Debit. Bank Name: " + bankName;
    }
}