package com.examples.problems.string;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateChars {
	public static void main(String[] args) {
		String input = "programming";
		withoutStream(input);
		withoutStream2(input);
		withStream(input);
	}

	static void withoutStream(String input) {
		String output = "";
		Set<Character> set = new LinkedHashSet<>();

		for (Character c : input.toCharArray()) {
			set.add(c);
		}

		for (Character character : set) {
			output = output + character;
		}

		System.out.println(output);
	}

	static void withoutStream2(String input) {
		StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (sb.indexOf(String.valueOf(c)) == -1) {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}

	static void withStream(String input) {
		String output = input.chars().mapToObj(c -> String.valueOf((char) c)).distinct().collect(Collectors.joining());
		System.out.println(output);
	}
}