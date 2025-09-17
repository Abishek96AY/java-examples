package com.examples.problems.string;

import java.util.stream.Stream;

public class PalindromeString {
	public static void main(String[] args) {
		String input = "Mom";
		withoutStream2(input);
	}

	public static void withoutStream1(String input) {
		input = input.toLowerCase();
		String reversed = ""; // identity
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			reversed = c + reversed; // accumulator logic (prepend character)
		}
		System.err.println("Palindrome :: " + input.equals(reversed));
	}

	public static void withoutStream2(String input) {
		input = input.toLowerCase();
		String reversed = new StringBuilder(input).reverse().toString();
		System.out.println(input.equals(reversed));
	}

	public static void withStream(String input) {
		input = input.toLowerCase();
		String reversed = input.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);
		System.out.println("Palindrome (Stream): " + input.equals(reversed));
	}

	public static void withStreamBuilder(String input) {
		input = input.toLowerCase();
		String reversed = Stream.of(input).map(s -> new StringBuilder(s).reverse().toString()).findFirst().orElse("");
		System.out.println("Palindrome (StreamBuilder): " + input.equals(reversed));
	}
}