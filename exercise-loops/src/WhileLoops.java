import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        //1. Countdown Timer (While Loop)
        //● Prompt the user for a starting number.
        //● Use a while loop to count down to zero.
        //● Print "Blast off!" when it reaches zero
        System.out.println("Enter a starting number: ");
        int startingNumber = Integer.parseInt(console.nextLine());

        while (startingNumber > 0) {
            System.out.println("Counter.. " + startingNumber + "!");
            startingNumber--;
        }
        System.out.println("BLAST OFF!!");
        //2. Password Validator (While Loop)
        //● Ask the user to enter a password.
        //● Keep asking until they enter the correct password ("letmein").

        Boolean password = false;

        while (!password) {
            System.out.println("Please enter your password: ");
            String passAttempt = console.nextLine();
            if (passAttempt.equals("letmein")) {
                password = true;
            }
        }
        System.out.println("Now logged in.");
    }
}
