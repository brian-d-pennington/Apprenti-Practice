package model;

public class Artifact {
    private String primarySpecialty;
    // class variables
    private String name;
    private Person discoverer;
    private Person curator;
    private int yearOfDiscovery;

    // overloaded constructors
    public Artifact(String name, Person discoverer, Person curator, int yearOfDiscovery) {
        this.name = name;
        this.discoverer = discoverer;
        this.curator = curator;
        this.yearOfDiscovery = yearOfDiscovery;
    }

    public Artifact(String name, Person discoverer, String primarySpecialty, int yearOfDiscovery) {
        this.name = name;
        this.discoverer = discoverer;
        this.primarySpecialty = primarySpecialty;
        this.yearOfDiscovery = yearOfDiscovery;
    }

    // getters
    public String getName() {
        return name;
    }

    public Person getDiscoverer() {
        return discoverer;
    }

    public Person getCurator() {
        if (this.curator == null) {
            return discoverer;
        } else {
            return curator;
        }
    }

    public int getYearOfDiscovery() {
        return yearOfDiscovery;
    }

    // methods
    @Override
    public String toString() {
        return "Artifact: " + this.name + " (" + yearOfDiscovery + ")";
    }
}
