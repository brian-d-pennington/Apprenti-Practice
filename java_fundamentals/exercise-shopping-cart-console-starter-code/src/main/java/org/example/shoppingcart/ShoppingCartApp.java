package org.example.shoppingcart;
import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        // Define an instance of Scanner
        Scanner console = new Scanner(System.in);
        // Prompt for tax exempt
        String taxExempt;
        String shipping;
        int orderQuantity;
        String promoCode;

        // prompts
        System.out.println("Are you tax exempt? Y/N");
        taxExempt = console.nextLine();
        System.out.println("Do you need shipping? Y/N");
        shipping = console.nextLine();
        System.out.println("How many widgets would you like to order?");
        //orderQuantity = Integer.parse(console.nextLine());
        orderQuantity = Integer.parseInt(console.nextLine());
        System.out.println("Enter promo code: ");
        promoCode = console.nextLine();
        // Print details
        System.out.println("User's tax exemption status: " + taxExempt);
        System.out.println("Does user need shipping: " + shipping);
        System.out.println("Order quantity: " + orderQuantity);
        System.out.println("Promo code: " + promoCode);

        System.out.println("Bye");
    }

}
