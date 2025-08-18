package org.example.shoppingcart;

/**
 * If tax exempt don't charge tax.
 * If order total is more than $100 apply discount 5%
 * If order total is more than $500 apply discount 10%
 * If promo code is valid, apply free shipping (unless next-day or 2-day)
 */
public class ShoppingCartApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        java.util.Scanner console = new java.util.Scanner(System.in);

        double productPrice = 4.99;
        int productQuantity = 78;
        double totalCost = productPrice * productQuantity;
        double discount; // for decision logic

        System.out.println("Product Price: " + productPrice);
        System.out.println("Product Quantity: " + productQuantity);
        System.out.println("Total Cost: " + totalCost);

        // Prompt for tax exempt
        System.out.print("Are you tax-exempt? (y/n) ");
        String taxExempt = console.nextLine();

        // Prompt for shipping
        System.out.print("Shipping? (standard / overnight / two-day) ");
        String shipping = console.nextLine();

        // Prompt for promo code
        System.out.print("Promo code for free shipping? ");
        String promoCode = console.nextLine();

        // DECISION LOGIC ***************************************
        // tax

        if (taxExempt.equals("yes")) {
            System.out.println("Tax exempt, no tax applied to order!");
        } else {
            double tax = totalCost * .07;
            tax = Double.parseDouble(String.format("%.2f", tax));
            totalCost += tax;
            System.out.println("7% tax applied. Total order now $" + totalCost);
        }

        // order discount applies?

        if (totalCost >= 100 && totalCost <= 500) {
            discount = totalCost * .05;
            totalCost -= discount;
            discount = Double.parseDouble(String.format("%.2f", discount));
            System.out.println(discount + " was subtracted from your order. The total cost is now $" + totalCost);
        } else if (totalCost > 500 ) {
            discount = totalCost * .1;
            totalCost -= discount;
            discount = Double.parseDouble(String.format("%.2f", discount));
            System.out.println(String.format("%.2f", discount) + " was subtracted from your order. The total cost is now $" + totalCost);
        }

        // shipping
        if (promoCode.equals("free123")) {
            System.out.println("You get free shipping! Order cost still $" + totalCost);
        } else {
            switch (shipping) {
                case "standard":
                    totalCost += 2.00;
                    System.out.println("You've selected Standard shipping, total cost now $" + totalCost);
                    break;
                case "overnight":
                    totalCost += 10.00;
                    System.out.println("You've selected Overnight shipping, total cost now $" + totalCost);
                    // math
                    break;
                case "two-day":
                    totalCost += 5.00;
                    System.out.println("You've selected 2-Day shipping, total cost now $" + totalCost);

                    break;
                default:
                    totalCost += 2.00;
                    System.out.println("Standard shipping selected, total cost now $" + totalCost);
            }
        }


        // Print details
//        System.out.println("\nDetails:");
//        System.out.println("Tax-exempt: " + taxExempt);
//        System.out.println("Shipping: " + shipping);
//        System.out.println("Promo code: " + promoCode);

        System.out.println("Thank you for your order!");
    }
}