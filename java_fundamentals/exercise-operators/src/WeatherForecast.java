public class WeatherForecast {
    public static void main(String[] args) {
//        Declare and initialize variables:
        double temperatureCelsius = 25.0; // Current temperature in Celsius
        boolean isRaining = false; // Indicates if it's raining
        int windSpeedKmh = 10; // Wind speed in km/h

//        1. Convert Celsius to Fahrenheit using the formula:
//              temperatureFahrenheit = (temperatureCelsius×9/5) + 32
        double temperatureFahrenheit = (temperatureCelsius * 9/5) + 32;
        System.out.println("Temp from Celsius: "+temperatureCelsius+" converted to Fahrenheit: "+temperatureFahrenheit);
//        2. Use Assignment Operators:
//               Increase temperature by 5 degrees (+=).
        temperatureCelsius += 5;
        System.out.println("Temperature increased 5 degrees C: "+temperatureCelsius);
//               Increase wind speed by 5 km/h (+=).
        windSpeedKmh += 5;
        System.out.println("Windspeed increased 5 km/h to: "+windSpeedKmh);
//        3. Use Comparison Operators:
//               Check if the temperature in Fahrenheit exceeds 85°F.
        boolean exceedEightyFive = temperatureFahrenheit > 85;
        System.out.println("Does temperature exceed 85 degrees F? "+exceedEightyFive);
//               Check if the wind speed is greater than 20 km/h.
        boolean windyDay = windSpeedKmh > 20;
        System.out.println("Is today a windy day? "+windyDay);
//        4. Use Logical Operators:
//               Determine if it's a good day to go outside (not raining AND temperature
//               between 60°F - 85°F).
        boolean toGoOutside = !isRaining && (temperatureFahrenheit > 60 && temperatureFahrenheit < 85);
        System.out.println("Is today a good day to go outside? "+toGoOutside);
//    Determine if there's a weather warning (wind speed above 30 km/h OR
//        temperature below 0°C).
        boolean toWarn = windSpeedKmh > 30 || temperatureCelsius < 0;
        System.out.println("Is there a weather warning? "+toWarn);
//        5. Print the results in a readable format.
//
    }
}
