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

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPrimarySpecialty(String primarySpecialty) {
        this.primarySpecialty = primarySpecialty;
    }

    // methods
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + primarySpecialty;
    }
}
