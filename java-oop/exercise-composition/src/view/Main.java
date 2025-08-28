package view;

import model.Artifact;
import model.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner console = new Scanner(System.in);
    public static Person person;
    public static Person personCurator;
    public static Artifact artifact;

    // input variables
    public static String artifactInput;
    public static int yearInput;
    public static String firstNameInput;
    public static String lastNameInput;
    public static String primarySpecialtyInput;
    public static String discovererAlsoCurator;
    public static String curatorFirstNameInput;
    public static String curatorLastNameInput;
    public static String curatorSpecialtyInput;

    public static void main(String[] args) {
        System.out.println("Please enter the name of a new artifact: ");
        try {
            artifactInput = console.nextLine();
        } catch (Exception e) {
            System.out.println(" "); // fill later
        }
        System.out.println("Please enter the year of discovery: ");
        try {
            yearInput = Integer.parseInt(console.nextLine());
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        System.out.println("Please Enter the name and primary specialty of the discoverer.");
        System.out.println("First name: ");
        try {
            firstNameInput = console.nextLine();
        } catch (Exception e) {
            System.out.println(" "); // fill later
        }
        System.out.println("Last name: ");
        try {
            lastNameInput = console.nextLine();
        } catch (Exception e) {
            System.out.println(" "); // fill later
        }
        System.out.println("Primary specialty: ");
        try {
            primarySpecialtyInput = console.nextLine();
        } catch (Exception e) {
            System.out.println(" "); // fill later
        }
        System.out.println("Is the discover also the curator? Y/N");
        boolean isCurator;
        while (true) {
            discovererAlsoCurator = console.nextLine();
            if (discovererAlsoCurator.equalsIgnoreCase("y")) {
                isCurator = true;
                break;
            } else if (discovererAlsoCurator.equalsIgnoreCase("n")) {
                isCurator = false;
                System.out.println("Please enter the name and specialty of the curator. Enter first name:");
                curatorFirstNameInput = console.nextLine();
                System.out.println("Last name:");
                curatorLastNameInput = console.nextLine();
                System.out.println("Curator specialty: ");
                curatorSpecialtyInput = console.nextLine();
                break;
            } else {
                System.out.println("Please enter Y or N only");
            }
        }
        // instantiate new Person and Artifact with input information
        person = new Person(firstNameInput, lastNameInput, primarySpecialtyInput);
        if (isCurator) {
            artifact = new Artifact(artifactInput,person, person, yearInput);
        } else {
            artifact = new Artifact(artifactInput,person, primarySpecialtyInput, yearInput);
            personCurator = new Person(curatorFirstNameInput, curatorLastNameInput, curatorSpecialtyInput);
        }

        System.out.println("------------Report--------------");
        System.out.println("Artifact: " + artifact.toString());
        System.out.println("Discoverer: " + artifact.getDiscoverer());
        System.out.println("Curator: " + personCurator.toString());
    }
}

//Artifact: The Ark of the Covenent (1936)
//Discoverer: Wyoming Smith, Archaeologist and Adventurer
//Curator: Mark Blodsky, Nebbishy Academioc

//        5. If the user answers N for #4, enter the name and primary specialty of the curator
//6. Print out a report based on the following template: