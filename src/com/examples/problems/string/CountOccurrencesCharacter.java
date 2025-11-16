package com.examples.problems.string;

public class CountOccurrencesCharacter {
	public static void main(String[] args) {
		String input = "Hello";
		Character searchKeyword = 'l';
		withOutStream(input, searchKeyword);
		withStream(input, searchKeyword);
	}

	static void withOutStream(String input, Character searchKeyword) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == searchKeyword) {
				count++;
			}
		}
		System.out.println(count);
	}

	static void withStream(String input, Character searchKeyword) {
		Long l = input.chars().mapToObj(e -> (char) e).filter(e -> e.equals(searchKeyword)).count();

		System.out.println(l);
	}
}