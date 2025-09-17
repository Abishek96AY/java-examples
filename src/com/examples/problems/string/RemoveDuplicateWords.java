package com.examples.problems.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateWords {
	public static void main(String[] args) {
		String inputString = "Java is a programming language and Java is widely used in the software industry.";
		withOutStream(inputString);
		withStream(inputString);
	}

	static void withOutStream(String inputString) {
		String[] words = inputString.split("\\s+");
		Set<String> uniqueWords = new HashSet<>();
		StringBuilder resultBuilder = new StringBuilder();
		for (String word : words) {
			if (uniqueWords.add(word)) {
				resultBuilder.append(word).append(" ");
			}
		}
		System.out.println(resultBuilder.toString().trim());
	}

	static void withStream(String input) {
		String output = Arrays.stream(input.split("\\s+")).map(s -> s).distinct().collect(Collectors.joining(" "));
		System.out.println(output);
	}
}