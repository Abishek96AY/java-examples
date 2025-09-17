package com.examples.problems.string;

public class ReverseWord {
	public static void main(String[] args) {
		String input = "hello";
		withStream(input);
	}

	public static void withOutStream1(String input) {
		String output = new StringBuilder(input).reverse().toString();
		System.out.println(output);
	}

	public static void withOutStream2(String input) {
		char[] charArr = input.toCharArray();
		String output = "";
		for (int i = charArr.length - 1; i >= 0; i--) {
			output = output + charArr[i];
		}
		System.out.println(output);
	}

	public static void withOutStream3(String input) {
		String output = ""; // identity
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			output = c + output; // accumulator logic (prepend character)
		}
		System.out.println(output);
	}

	public static void withStream(String input) {
		String output = input.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);
		System.out.println(output);
	}
}