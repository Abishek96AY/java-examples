package com.examples.problems.string;

public class FindStringLength {
	public static void main(String[] args) {
		String input = "Hello, world!";
		withoutStream1(input);
		withoutStream2(input);
		withStream(input);
	}

	public static void withoutStream1(String input) {
		int count = 0;
		for (char c : input.toCharArray()) {
			count++;
		}
		System.out.println("The length of the string is : " + count);
	}

	public static void withoutStream2(String input) {
		System.out.println("The length of the string is : " + input.length());
	}

	public static void withStream(String input) {
		Long count = input.chars().mapToObj(c -> (char) c).count();

		System.out.println("The length of the string is : " + count);
	}
}