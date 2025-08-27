package ui;

import model.Locker;
import model.LockerManager;

import java.util.Scanner;

public class Main {
    public static String[] menuOptions = {"Add a locker", "Remove a locker", "Store an item in a locker", "Retrieve an item from a locker", "Display all lockers", "Exit the program"};

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LockerManager manager = new LockerManager(); // instantiates Locker Manager

        System.out.println("Welcome to the Locker Management System!");

        while (true) { // main menu
            System.out.println("Enter a number to choose one of the following:");
            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println(i+1 + ": " + menuOptions[i]);
            }
            int choice = Integer.parseInt(console.nextLine());

            switch (choice) {
                case 1: // add locker
                    System.out.println("Which locker would you like? Enter 1-50");
                    String idChoice = console.nextLine();
                    if (manager.getLocker(idChoice) == null) {
                        Locker newLocker = new Locker(idChoice);
                        manager.addLocker(idChoice);
                        System.out.println("New locker added! " + newLocker);
                    } else {
                        System.out.println("Locker number " + idChoice + " is not available. Try adding a different locker");
                    }
                    break;
                case 2: // remove locker
                    System.out.println("Which locker would you like to remove");
                    String idToDelete = console.nextLine();
                    manager.removeLocker(idToDelete);
                    break;
                case 3: // add item to locker
                    System.out.println("Which locker do you want to add an item to?");
                    String idToAdd = console.nextLine();
                    System.out.println("Enter an item you'd like to store in the locker");
                    String itemToStore = console.nextLine();
                    manager.getLocker(idToAdd).storeItem(itemToStore);
                    String thisLockerContents = manager.getLocker(idToAdd).getContents();
                    System.out.println("This locker now contains " + thisLockerContents);
                    break;
                case 4: // retrieve an item
                    System.out.println("Which locker do you want to retrieve an item from?");
                    String idToRetrieve = console.nextLine();
                    String lockerContents = manager.getLocker(idToRetrieve).getContents();
                    System.out.println(lockerContents + " retrieved.");
                    break;
                case 5: // display all lockers
                    manager.displayAllLockers();
                    break;
                case 6:
                    System.out.println("Thank you for using the Locker Management System. Goodbye.");
                    break;

                default:
                    System.out.println("Please enter 1-6");
            }
        }
    }
}