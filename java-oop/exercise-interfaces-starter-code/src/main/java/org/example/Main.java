package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean listComplete = false;

        // Define an array of devices to store 5 devices
        List<Connectable> connectables = new ArrayList<>();

        System.out.println("Welcome to the Device Manager App!!");
        System.out.println("===================================\n");

        System.out.println("Setup the devices");
        System.out.println("=================\n");
        while (!listComplete) {
            switch(promptInt("Select a device to add: 1. TV, 2. Refrigerator, 3. Toaster", 1, 3)) {
                case 1:
                    System.out.println("You chose a TV");
                    connectables.add(new Television());
                    break;
                case 2:
                    System.out.println("You chose a Refrigerator");
                    connectables.add(new Refrigerator());
                    break;
                case 3:
                    System.out.println("You chose a Toaster");
                    connectables.add(new Toaster());
                    break;
                default:
                    System.exit(0);
            }
            if(!promptString("Add another device? Y/N").equalsIgnoreCase("y")) {
                listComplete = true;
            }
        }

        listComplete = false;
        System.out.println("Interact with the devices");
        System.out.println("=========================\n");
        while (!listComplete) {
            switch (promptInt("Choose option: 1. Get Device Name 2. Turn On Device 3. Turn Off Device 4. Get Device Status 5. Quit", 1,5)){
                case 1:
                    System.out.println("Device names:");
                    for (Connectable connectable : connectables) {
                        System.out.println(connectable.getName());
                    }
                    break;
                case 2:
                    System.out.println("Turn On Devices");
                    for (Connectable connectable : connectables) {
                        connectable.turnOn();
                    }
                    break;
                case 3:
                    System.out.println("Turn Off Devices");
                    for (Connectable connectable : connectables) {
                        connectable.turnOff();
                    }
                    System.out.println("Devices are now off.");
                    break;
                case 4:
                    System.out.println("Device statuses:");
                    for (Connectable connectable : connectables) {
                        if (connectable.getState()) {
                            System.out.println(connectable.getName() + " is on.");
                        } else {
                            System.out.println(connectable.getName() + " is off.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thanks for using the Device Manager App. Bye!");
                    System.exit(0);
                    break;
            }
        }
    }

    // utility method to prompt user for string
    public static String promptString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
    // Utility method to prompt user for integer input
    public static int promptInt(String message) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {

            try {
                System.out.println(message);
                String input = sc.nextLine();
                result = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }
        return result;
    }

    // Utility method to prompt user for integer input within a range
    public static int promptInt(String message, int min, int max) {
        int result = 0;

        boolean isValid = false;
        while (!isValid) {
            result = promptInt(message);
            if (result > max || result < min) {
                System.out.println("Entry out of range: " + min + " - " + max + ". Try again.");
            }
            else {
                isValid = true;
            }
        }
        return result;
    }
}