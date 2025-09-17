import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
    //1. Count Up! (For Loop)
    //● Write a program that prints numbers 1 to 100 using a for loop.
    //● Modify the program to print only even numbers.
        for (int i = 2; i <= 100; i+=2) {
            System.out.println(i);
        }

    //2.Multiplication Table (For Loop)
    //● Ask the user for a number.
    //● Print the multiplication table (1 to 10) for that number
        System.out.println("Enter a number: ");
        int enteredNumber = Integer.parseInt(console.nextLine());

        for (int i = 1; i <= 10; i++) {
            System.out.println(enteredNumber + " times " + i + " = " + (enteredNumber * i));
        }
    }
}
