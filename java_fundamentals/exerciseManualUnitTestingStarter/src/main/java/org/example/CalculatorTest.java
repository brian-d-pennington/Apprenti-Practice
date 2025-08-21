package org.example;

public class CalculatorTest {
    public static void main(String[] args) {
        // set up
        Calculator test = new Calculator();
        int[] numbers;
        int result;

        // test
        // add 2 numbers
        numbers = new int[] {2,5};
        result = test.add(numbers);
        if (result == 7) {
            System.out.println("Add works! Expected 7, got "+result);
        } else {
            System.out.println("Add function failed, expected 7, got "+result);
        }

        // add 4 numbers
        numbers = new int[] {2, 3, 4, 5};
        result = test.add(numbers);
        if (result == 14) {
            System.out.println("Add works! Expected 14, got "+result);
        } else {
            System.out.println("Add function failed, expected 14, got "+result);
        }

        // check for null
        numbers = null;
        result = test.add(numbers);
        if (result == 0) {
            System.out.println("Null check works! Expected 0, got "+result);
        } else {
            System.out.println("Null check failed, expected 0, got "+result);
        }

        // Add 2 zeros
        numbers = new int[] {0,0};
        result = test.add(numbers);
        if (result == 0) {
            System.out.println("Add 2 zeros works! Expected 0, got "+result);
        } else {
            System.out.println("Add 2 zeros failed, expected 0, got "+result);
        }

        // subtract 2 numbers
        numbers = new int[] {7,5};
        result = test.subtract(numbers);
        if (result == 2) {
            System.out.println("Subtract works! Expected 2, got "+result);
        } else {
            System.out.println("Subtract failed, expected 2, got "+result);
        }

        // subtract 4 numbers
        numbers = new int[] {25,5,4,3};
        result = test.subtract(numbers);
        if (result == 13) {
            System.out.println("Subtract works! Expected 13, got "+result);
        } else {
            System.out.println("Subtract failed, expected 13, got "+result);
        }

        // subtract 1 number
        numbers = new int[] {7};
        result = test.subtract(numbers);
        if (result == 7) {
            System.out.println("Subtract works! Expected 7, got "+result);
        } else {
            System.out.println("Subtract failed, expected 7, got "+result);
        }

        // check for null
        numbers = null;
        result = test.subtract(numbers);
        if (result == 0) {
            System.out.println("Null check works! Expected 0, got "+result);
        } else {
            System.out.println("Null check failed, expected 0, got "+result);
        }
        // subtract 2 zeros
        // Add 2 zeros
        numbers = new int[] {0,0};
        result = test.subtract(numbers);
        if (result == 0) {
            System.out.println("Subtract 2 zeros works! Expected 0, got "+result);
        } else {
            System.out.println("Subtract 2 zeros failed, expected 0, got "+result);
        }
        // variables in scope, no garbage collection necessary
    }
}
