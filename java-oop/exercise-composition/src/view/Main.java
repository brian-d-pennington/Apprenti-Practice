package view;

import model.Artifact;
import model.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner console = new Scanner(System.in);
    public static Person person = new Person("","","");
    public static Person personCurator = new Person("","","");
    public static Artifact artifact = new Artifact("",person,personCurator,0);
    public static String discovererAlsoCurator;

    public static void main(String[] args) {
        System.out.println("Please enter the name of a new artifact: ");
        try {
            artifact.setName(console.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Please enter the year of discovery: ");
        try {
            artifact.setYearOfDiscovery(Integer.parseInt(console.nextLine()));
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        System.out.println("Please Enter the name and primary specialty of the discoverer.");
        System.out.println("First name: ");
        try {
            person.setFirstName(console.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Last name: ");
        try {
            person.setLastName(console.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Primary specialty: ");
        try {
            person.setPrimarySpecialty(console.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Is the discover also the curator? Y/N");
        while (true) {
            discovererAlsoCurator = console.nextLine();
            if (discovererAlsoCurator.equalsIgnoreCase("y")) {
                artifact.setDiscoverer(person);
                break;
            } else if (discovererAlsoCurator.equalsIgnoreCase("n")) {
                System.out.println("Please enter the name and specialty of the curator. Enter first name:");
                personCurator.setFirstName(console.nextLine());
                System.out.println("Last name:");
                personCurator.setLastName(console.nextLine());
                System.out.println("Curator specialty: ");
                personCurator.setPrimarySpecialty(console.nextLine());
                break;
            } else {
                System.out.println("Please enter Y or N only");
            }
        }

        System.out.println("------------Report--------------");
        System.out.println("Artifact: " + artifact.toString());
        System.out.println("Discoverer: " + artifact.getDiscoverer());
        if (discovererAlsoCurator.equalsIgnoreCase("y")) {
            System.out.println("Curator: " + artifact.getDiscoverer());
        } else {
            System.out.println("Curator: " + personCurator.toString());
        }
    }
}