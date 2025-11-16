package com.examples.problems.string;

public class StringIsNumeric {
	public static void main(String[] args) {
		String input = "12345";

		withOutStream(input); // loop approach
		withStream(input); // stream approach
	}

	// Approach 1: Without Streams
	static void withOutStream(String input) {
		boolean output = true;
		char[] c = input.toCharArray();
		for (Character cha : c) {
			if (!Character.isDigit(cha)) {
				output = false;
				break;
			}
		}
		System.out.println(output);
	}

	// Approach 2: With Streams
	static void withStream(String input) {
		boolean output = input.chars().allMatch(Character::isDigit);
		System.out.println(output);
	}
}