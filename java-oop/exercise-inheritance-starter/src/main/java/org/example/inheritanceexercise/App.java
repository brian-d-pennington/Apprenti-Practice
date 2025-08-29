package org.example.inheritanceexercise;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();

        //Create your sample payments here
        CreditCard creditCard = new CreditCard(123, 50.00, 123456789, "Visa");
        payments.add(creditCard);

        DirectDebit directDebit = new DirectDebit(4422, 500.00, 382838883, 283923883, "Chase", 5.00);
        payments.add(directDebit);

        GiftCard giftCard = new GiftCard(2888, 300.00, "2893dds9", 550.00, 50);
        payments.add(giftCard);

        CreditCard creditCard2 = new CreditCard(2200, 1150.00, 929292229, "Mastercard");
        payments.add(creditCard2);

        DirectDebit directDebit2 = new DirectDebit(1009, 300.50, 39993393, 338836556, "Wells Fargo", 50.00);
        payments.add(directDebit2);

        GiftCard giftCard2 = new GiftCard(2888, 500.00, "2893dds9", 100.00, 15);
        payments.add(giftCard2);

        //Payments Report
        for (Payment p : payments) {
            System.out.println(p.toString());
        }

        //Payment Processing Report
        for (Payment p : payments) {
            p.processPayment();
        }

        //Uncomment this section after implementing GiftCardPayment to verify that balances are correct after processing
//        //Post processing gift card balance check
        for (Payment p : payments) {
            if (p instanceof GiftCard) {
                System.out.println(p.toString());
            }
        }
    }
}
