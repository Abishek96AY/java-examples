package com.examples.logical;

public class PerfectSquare {
	public static void main(String[] args) {
        int number = 16; // Step 1: Number to check
        double squareRoot = Math.sqrt(number); // Step 2: Calculating square root

        // Step 3: Checking if the square of the rounded square root equals the original number
        if ((int)squareRoot * (int)squareRoot == number) {
            System.out.println(number + " is a perfect square.");
        } else {
            System.out.println(number + " is not a perfect square.");
        }
    }
}
