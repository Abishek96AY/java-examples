package com.examples.problems.string;

public class CountLowercaseLetters {
	public static void main(String[] args) {
		String input = "Hello World";

		withOutStream(input);
		withStream(input);
	}

	// --- Without Streams ---
	static void withOutStream(String input) {
		int count = 0;
		for (char c : input.toCharArray()) {
			if (Character.isLowerCase(c)) {
				count++;
			}
		}
		System.out.println(count);
	}

	// --- With Streams ---
	static void withStream(String input) {
		long count = input.chars().filter(Character::isLowerCase).count();
		System.out.println(count);
	}
}