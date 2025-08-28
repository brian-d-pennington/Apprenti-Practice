package model;

public class Person {
    // class variables
    private String firstName;
    private String lastName;
    private String primarySpecialty;

    // constructor
    public Person(String firstName, String lastName, String primarySpecialty){
        this.firstName = firstName;
        this.lastName = lastName;
        this.primarySpecialty = primarySpecialty;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPrimarySpecialty() {
        return primarySpecialty;
    }

    // methods
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + primarySpecialty;
    }
}
