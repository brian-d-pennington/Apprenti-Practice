package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {

  public static void main(String[] args) {
    System.out.println("Welcome to the shopping cart app!");
    String[] addresses = { "123 Main St", "456 Main St", "789 Main St" };
    String[] sizes = { "small", "medium", "large" };

    java.util.Scanner console = new java.util.Scanner(System.in);
    boolean confirm = false;
    String taxExempt = "";
    String shipping = "";
    String promoCode = "";

    while (!confirm) {
      int addressIndex = 0;
      int sizeIndex = 0;
      String address = null;
      String size = null;
      // Prompt for tax-exempt
      while (true) {
          try {
              taxExempt = promptUserForString("Are you tax-exempt? (y/n)");
              // input must equal y or n
              if (taxExempt.equals("y") || taxExempt.equals("n")) {
                  break;
              } else {
                  throw new IllegalArgumentException("Must select y or n");
              }
          } catch (IllegalArgumentException e) {
              System.out.println(e.getMessage());
          }
      }


      // Prompt for shipping address
        while (address == null) {
            // checks for valid menu option, in this case 1, 2, or 3
            try {
                displayChoices(addresses);
                addressIndex = promptUserForInt("Shipping address?") - 1;
                address = addresses[addressIndex]; // assigning value breaks it out of Null
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter a valid menu option");
            }
        }

      // Prompt for shipping
        while (true) {
            // input must exactly match options
            try {
                shipping = promptUserForString("Shipping? (standard/overnight/twoday)");
                if (shipping.equals("standard") || shipping.equals("overnight") || shipping.equals("twoday")) {
                    break;
                } else {
                    throw new IllegalArgumentException("Please enter one of the displayed options");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


      // Prompt for order quantity
      int orderQuantity = promptUserForInt("Order quantity?");

      // Prompt for Size
        while (size == null) {
            try {
                displayChoices(sizes);
                sizeIndex = promptUserForInt("Size?") - 1;
                size = sizes[sizeIndex]; // assigning value breaks it out of Null
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter a valid menu option");
            }
        }

      // Prompt for promo code
      promoCode = promptUserForString("Promo code for free shipping?");

      // Print details
      System.out.println("\nDetails:");
      System.out.println("Tax-exempt: " + taxExempt);
      System.out.println("Address: " + addresses[addressIndex]);
      System.out.println("Shipping: " + shipping);
      System.out.println("Size: " + sizes[sizeIndex]);
      System.out.println("Order quantity: " + orderQuantity);
      System.out.println("Promo code: " + promoCode);
      System.out.println("Confirm Order y/n");
      confirm = "y".equals(console.nextLine());
    }

    System.out.println("Bye");
  }

  // Method for display choices
  private static void displayChoices(String[] choices) {
      // check for empty array on the back end
      try {
          if (choices == null || choices.length == 0) {
              throw new IllegalArgumentException("Back end array cannot be empty");
              // No loop here, the error only needs to display once
          } else {
              for (int i = 0; i < choices.length; i++) {
                  System.out.println(i + 1 + ": " + choices[i]);
              }
          }
      } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
      }
  }

  // Method for prompt user for string
  private static String promptUserForString(String prompt) {
    Scanner console = new java.util.Scanner(System.in);
    System.out.println(prompt);
    return console.nextLine();
  }

  // Method for prompt user for int
    // exception handling for valid int input
    private static int promptUserForInt(String prompt) {
        java.util.Scanner console = new java.util.Scanner(System.in);
        int result = -1;
        while (true) {
            System.out.println(prompt);
            try {
                result = Integer.parseInt(console.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number"); //Error message
            }
        }
        return result;
    }
}
