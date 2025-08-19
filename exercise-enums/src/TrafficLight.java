public class TrafficLight {
    public static void main(String[] args) {
    //Traffic lights are programmed using an indexed array.

    //1. Create an enum named TrafficLight with values:
        //RED
        //YELLOW
        //GREEN
        enum Light {  // cannot use "TrafficLight" in class with same name
            RED,
            YELLOW,
            GREEN
        }

    //2. Store all values in an array using values().
    Light[] lights = Light.values();
    //3. Retrieve the correct signal based on a predefined index (1 for YELLOW).
        Light arrayCurrentSignal = lights[1];
        Light currentSignal = Light.values()[1];
    //4. Print the selected signal.
        System.out.println("The signal is currently: "+currentSignal);
        System.out.println("The signal is currently: "+arrayCurrentSignal);
    }
}
