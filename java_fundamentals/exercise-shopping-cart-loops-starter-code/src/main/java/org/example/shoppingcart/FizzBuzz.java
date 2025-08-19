package org.example.shoppingcart;

public class FizzBuzz {
    public static void main(String[] args) {
        // print 1 to 100
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Value at " + i + ": FizzBuzz");
            }
            if (i % 5 == 0) {
                System.out.println("Value at " + i + ": Buzz");
            }
            if (i % 3 == 0){
                System.out.println("Value at " + i + ": Fizz");
            }
        }
    }
}


