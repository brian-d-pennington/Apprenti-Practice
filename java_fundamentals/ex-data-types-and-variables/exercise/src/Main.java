//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise Code Starts Here:");


        //Sports Statistics
        //1 Declare and assign the following variables related to a soccer player:
        //2 playerName → store the name of a soccer player.
        String playerName = "Christiano Ronaldo";
        //3 jerseyNumber → store the player's jersey number.
        int jerseyNumber = 22;
        //4 position → store the player’s field position (e.g., "Goalkeeper").
        String position = "Forward";
        //5 isStarter → store whether the player is a starter (true or false).
        boolean isStarter = true;
        //6 teamName → store the name of the player’s team.
        String teamName = "Portugal";


        //Movie Information
        //1 Declare and assign the following variables for a movie:
        //2 movieTitle → store the title of a movie.
        String movieTitle = "King Kong";
        //3 releaseYear → store the year the movie was released.
        int releaseYear = 1933;
        //4 rating → store the rating (e.g., "PG-13").
        String rating = "NC-17";
        //5 isSequel → store whether the movie has a sequel (true or false).
        boolean isSequel = false;
        //6 leadActor → store the name of the lead actor.
        String leadActor = "a giant monkey";


        //Weather Report
        //1. Declare and assign the following variables for a weather forecast:
        //2. cityName → store the name of a city.
        String cityName = "Sheboygan";
        //3. temperature → store the temperature in Fahrenheit.
        int temperature = 77;
        //4. isRaining → store whether it is currently raining (true or false).
        boolean isRaining = true;
        //5. humidity → store the humidity percentage.
        double humidity = 72.3;
        //6. weatherCondition → store a short description of the weather (e.g. "Cloudy").
        String weatherCondition = "Light Rain";



        //Flight Information
        //1 Declare and assign the following variables for a flight at an airport:
        //2 flightNumber → store the flight number (e.g., "AA256").
        String flightNumber = "AA2234";
        //3 departureCity → store the departure city (e.g., "New York").
        String departureCity = "Tampa";
        //4 arrivalCity → store the arrival city (e.g., "Los Angeles").
        String arrivalCity = "Oakland";
        //5 gateNumber → store the gate number for the flight.
        String gateNumber = "C-25";
        //6 terminal → store the terminal number at the airport.
        int terminal = 3;
        //7 isDelayed → store whether the flight is delayed (true or false).
        boolean isDelayed = true;

        // soccer player (information may or may not be true)
        System.out.println("Player Name = " + playerName);
        System.out.println("his jersey number is " + jerseyNumber);
        System.out.println("His position is " + position);
        System.out.println("Is player a starter? " + isStarter);
        System.out.println("He plays for team " + teamName);
        System.out.println("_______________________________");
        // movie
        System.out.println("Name of the movie: " + movieTitle);
        System.out.println("Year of release: " + releaseYear);
        System.out.println("Movie rating: " + rating);
        System.out.println("Does it have a sequel? " + isSequel);
        System.out.println("Lead actor: " + leadActor);
        System.out.println("_______________________________");
        // weather report
        System.out.println("Name of city: " + cityName);
        System.out.println("Current Temperature: " + temperature + "F");
        System.out.println("Is it raining currently: " + isRaining);
        System.out.println("Current Humidity: " + humidity + "%");
        System.out.println("The weather is currently " + weatherCondition);
        System.out.println("_______________________________");
        // flight information
        System.out.println("Flight number: " + flightNumber);
        System.out.println("Departure city: " + departureCity);
        System.out.println("Arrival city: " + arrivalCity);
        System.out.println("Arrival gate number: " + gateNumber);
        System.out.println("Terminal: " + terminal);
        System.out.println("Is flight delayed? " + isDelayed);
    }
}