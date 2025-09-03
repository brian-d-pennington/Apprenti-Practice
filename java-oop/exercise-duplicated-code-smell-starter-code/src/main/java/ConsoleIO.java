import java.util.Scanner;

public class ConsoleIO {

    Scanner myScanner = new Scanner(System.in);

    public void writeMessage(String message) {
        System.out.println(message);
    }

    public int getInteger(String prompt) {
        return validateInteger(prompt);
    }

    public int getIntegerInBetween(String prompt, int min, int max) {
        return validateInteger(prompt, min, max);
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        String input = myScanner.nextLine();
        if (input == null || input.length() == 0) {
            input = "No input entered.";
        }
        return input;
    }

    public String getNonNullNonEmptyString (String prompt) {
        String result;
        while(true) {
            System.out.println(prompt);
            result = myScanner.nextLine();
            if(result == null || result.length() <= 0) {
                System.out.println("Enter a valid response.");
            } else {
                break;
            }
        }
        return result;
    }

    public double getMoney() {
        return validateMoney();
    }

    public double getPositiveMoney() {
        boolean mustBePositive = true;
        return validateMoney(mustBePositive);
    }
    // overloaded validate integer methods
    public int validateInteger(String prompt) {
        int number;
        while(true) {
            System.out.println(prompt);
            try {
                number = Integer.parseInt(myScanner.nextLine());
                break;
            } catch(Exception e) {
                System.out.println("Input a valid number");
            }
        }
        return number;
    }

    public int validateInteger(String prompt, int min, int max) {
        int number;
        while (true) {
            number = validateInteger(prompt);
            if(number >= min && number <= max) {
                break;
            }
            else {
                System.out.println("Enter a number between " + min + " and " + max);
            }
        }
        return number;
    }

    // overloaded validate money double

    public double validateMoney() {
        double number;
        while(true) {
            System.out.println("Enter the amount of cash on hand: ");
            try {
                number = Double.parseDouble(myScanner.nextLine());
                break;
            } catch(Exception e) {
                System.out.println("Input a valid number");
            }
        }
        return number;
    }

    public double validateMoney(boolean mustBePositive){
        double number;
        while (mustBePositive) {
            number = validateMoney();
            if(number > 0.0) {
                mustBePositive = false;
                return number;
            } else {
                System.out.println("Enter a positive amount of money.");
            }
        }
        return 0;
    }
}
