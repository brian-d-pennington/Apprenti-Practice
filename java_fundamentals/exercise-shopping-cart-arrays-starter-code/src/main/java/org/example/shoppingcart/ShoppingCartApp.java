package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {
  public static void main(String[] args) {
    Scanner console = new java.util.Scanner(System.in);

    System.out.println("Welcome to the shopping cart app!");

    // Create arrays to contain addresses and sizes
    String[] addresses = new String[4];
    addresses[0] = "2345 Meadow Dr.";
    addresses[1] = "Dandelion Road";
    addresses[2] = "777 Pine Way";
    addresses[3] = "632 Book Lane";

    String[] sizes = new String[3];
    sizes[0] = "small";
    sizes[1] = "medium";
    sizes[2] = "large";

    // Prompt for shipping address
      System.out.println("Choose which saved address to use: ");
      for (int i = 1; i < addresses.length; i++) {
          System.out.println(i+ ". "+ addresses[i]);
      }
      int shippingInput = Integer.parseInt(console.nextLine());
      System.out.println("You chose "+addresses[shippingInput]);
      System.out.println("-------------------------------");
    // Prompt for Size
      System.out.println("What size would you like?");
      for (int i = 0; i < sizes.length; i++) {
          System.out.println(i+1+ ". "+ sizes[i]);
      }
      while (true) { // size validator loop
          String size = console.nextLine();
          Boolean valid = false;
          for (String validSize: sizes) {
              if (validSize.equalsIgnoreCase(size)){
                  valid = true;
              }
          }
          if (valid) {
              System.out.println("You ordered a "+size);
              break;
          } else {
              System.out.println("Please re-enter size: ");
          }
      }
    // Print details
    System.out.println("\nDetails:");

    System.out.println("Bye");
  }
}
