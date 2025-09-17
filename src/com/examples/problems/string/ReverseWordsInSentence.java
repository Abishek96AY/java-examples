package com.examples.problems.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseWordsInSentence {
	public static void main(String[] args) {
		String input = "I love Java";
		withoutStream(input);
		withStream(input);
	}

	static void withoutStream(String input) {
		String[] words = input.split("\\s+"); // split on spaces
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	static void withStream(String input) {
		String output = Arrays.stream(input.split("\\s+"))
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverse(list);
					return String.join(" ", list);
				}));
		System.out.println(output);
	}
}