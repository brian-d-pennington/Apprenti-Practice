import java.util.Scanner;

public class AquariumTracker {
    public static void main(String[] args) {
        AquariumFish aquariumFish = new AquariumFish("Philum Mobulidae", "Devil Fish", 15.5, 29.0, "Plankton and krill" );
        // print out fish attributes and average temperature
        System.out.println("Species of fish : " + aquariumFish.getSpecies());
        System.out.println("Common name : " + aquariumFish.getCommonName());
        System.out.println("Maximum temp in C : " + aquariumFish.getMaxTemp());
        System.out.println("Minimum temp in C : " + aquariumFish.getMinTemp());
        System.out.println("Diet : " + aquariumFish.getDiet());
        System.out.println("Average Temp = " + aquariumFish.averageTemp());
    }
}
