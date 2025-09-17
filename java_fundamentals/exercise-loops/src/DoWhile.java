import java.util.Random;
import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        // math random from DuckDuckGo AI
        Random random = new Random();
        int min = 1; // inclusive
        int max = 50; // exclusive
        int randomNumber = random.nextInt(max - min) + min;
        //● Generate a random number between 1 and 50.
        //● Ask the user to guess the number.
        Boolean numberGuessed = false;

        do {
            System.out.println("(number for testing purposes: " + randomNumber + ")"); // aint got all day
            System.out.println("Please guess a number between 1 and 50: ");
            int numberEntered = Integer.parseInt(console.nextLine());

            if (numberEntered == randomNumber) {
                System.out.println("You guessed correctly! The number was " + randomNumber);
                numberGuessed = true;
            } else {
                System.out.println("Keep trying..");
            }
        } while (!numberGuessed);
        //● Keep asking until the user gets it right using a do-while loop.


//        Simple ATM System (Do-While Loop)
//        ● Start with an account balance of $500.
//        ● Ask the user if they want to:
//        ○ 1 Withdraw
//        ○ 2 Deposit
//        ○ 3 Check Balance
//        ○ 4 Exit
//        ● Use a do-while loop to keep asking until they choose to exit
        double balance = 500;
        Boolean transaction = true;

        do {
            System.out.println("Would you like to 1. Withdraw, 2. Deposit, 3. Check Balance, or 4. Exit?");
            System.out.println("Select 1, 2, 3, or 4: ");
            String input = console.nextLine();
            switch (input) {
                case "1":
                    // withdraw
                    System.out.println("You have up to $" + balance + " available. Enter withdrawal amount: ");
                    double withdraw = Double.parseDouble(console.nextLine());
                    balance -= withdraw;
                    break;
                case "2":
                    // deposit
                    System.out.println("Please enter amount to deposit: ");
                    double deposit = Double.parseDouble(console.nextLine());
                    balance += deposit;
                    break;
                case "3":
                    // check balance
                    System.out.println("You have $" + balance + " available.");
                    break;
                case "4":
                    System.out.println("Exiting. Thank you for your business!");
                    transaction = false;
                    break;
            }
        } while (transaction);

    }
}
