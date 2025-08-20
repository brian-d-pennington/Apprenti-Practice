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
    for (String address : addresses) {
        System.out.println(address);
    }
    // Prompt for Size

    // Print details
    System.out.println("\nDetails:");

    System.out.println("Bye");
  }
}
