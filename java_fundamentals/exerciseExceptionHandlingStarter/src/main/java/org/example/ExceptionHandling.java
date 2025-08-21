package org.example;

import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {
        // variables
        Scanner scanner = new Scanner(System.in);
        String email = "";
        String errMsg = "";
        int pin = 0;
        int age = 0;
        // user inputs
        while (true) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new IllegalArgumentException("Input cannot be 0!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // NumberFormatException
            }
        }

        while (true) {
            try {
                System.out.print("Enter your email: ");
                email = scanner.nextLine();

                if (email == null || email.trim().isEmpty()) {
                    errMsg += "Email cannot be empty";
                }
                if (!email.contains("@")){
                    errMsg += "\nAddress must contain @";
                }
                if (!email.contains(".")){
                    errMsg += "\nAddress must contain .";
                }
                if (!errMsg.isEmpty()) {
                    throw new IllegalArgumentException(errMsg);
                }
                if (!email.matches("^(.+)@(\\S+)$")){
                    errMsg = "Email Cannot be blank. Email must Have @ and . contained in the input";
                    throw new IllegalArgumentException(errMsg);
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        while (true) {
            try {
                System.out.print("Enter your 4-digit PIN: ");
                String pinInput = scanner.nextLine();
                if (!pinInput.matches("\\d{4}")) {
                    throw new IllegalArgumentException("Must be a 4 digit number.");
                }
                pin = Integer.parseInt(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }



        System.out.println("\nRegistration Successful!");
        // print details
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("PIN: " + pin);
    }
}