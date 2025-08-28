package model;

public class Artifact {
    // class variables
    private String name;
    private Person discoverer;
    private Person curator;
    private int yearOfDiscovery;

    // constructor
    public Artifact(String name, Person discoverer, Person curator, int yearOfDiscovery) {
        this.name = name;
        this.discoverer = discoverer;
        this.curator = curator;
        this.yearOfDiscovery = yearOfDiscovery;
    }

    // getters
    public Person getDiscoverer() {
        return discoverer;
    }

    // setters


    public void setName(String name) {
        this.name = name;
    }

    public void setDiscoverer(Person discoverer) {
        this.discoverer = discoverer;
    }

    public void setYearOfDiscovery(int yearOfDiscovery) {
        this.yearOfDiscovery = yearOfDiscovery;
    }

    // methods
    @Override
    public String toString() {
        return this.name + " (" + yearOfDiscovery + ")";
    }
}
