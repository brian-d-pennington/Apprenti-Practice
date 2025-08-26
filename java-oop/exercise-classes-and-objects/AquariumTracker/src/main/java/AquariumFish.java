public class AquariumFish {
    // local variables
    private String species;
    private String commonName;
    private double maxTemp;
    private double minTemp;
    private String diet;
    // constructor
    public AquariumFish(String species, String commonName, double maxTemp, double minTemp, String diet) {
        this.species = species;
        this. commonName = commonName;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.diet = diet;
    }
    // getters and setters

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    // methods

    public double averageTemp() {
        return (minTemp + maxTemp) / 2;
    }
}
