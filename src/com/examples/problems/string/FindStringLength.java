package com.examples.problems.string;

public class FindStringLength {
	public static void main(String[] args) {
		// Example string
		String exampleString = "Hello, world!";

		// Find the length without using the length() method
		int length = findLength(exampleString);

		// Print the length
		System.out.println("The length of the string is: " + length);
	}

	// Method to find the length of a string without using length()
	public static int findLength(String str) {
		int count = 0;

		// Use a for-each loop to iterate over each character in the string
		for(char c : str.toCharArray()) {
			count++;
		}

		return count;
	}
}
