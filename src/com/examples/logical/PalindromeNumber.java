package com.examples.logical;

public class PalindromeNumber {
	  public static void main(String[] args) {
	        int originalNumber = 12321; // Step 1: Number to be checked
	        int reversedNumber = 0;
	        int number = originalNumber; // Temporary variable to hold the original number

	        // Step 2: Reversing the number
	        while (number != 0) {
	            int lastDigit = number % 10;
	            reversedNumber = reversedNumber * 10 + lastDigit;
	            number /= 10;
	        }

	        // Step 3: Comparing the original number with the reversed number
	        if (originalNumber == reversedNumber) {
	            System.out.println(originalNumber + " is a palindrome number.");
	        } else {
	            System.out.println(originalNumber + " is not a palindrome number.");
	        }
	    }
}
