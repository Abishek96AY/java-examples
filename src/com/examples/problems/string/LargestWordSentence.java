package com.examples.problems.string;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestWordSentence {
	public static void main(String[] args) {
		String input = "Java is amazing";
		
		withOutStream(input);
		withStream(input);
	}

	static void withOutStream(String input) {
		String[] words = input.split("\\s+");
        String largest = "";
        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
        }
        System.out.println(largest);
	}

	static void withStream(String input) {
		String output = Arrays.stream(input.split("\\s+"))
				.collect(Collectors.toMap(e -> e, e -> e.length()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.map(e -> e.getKey())
				.orElse(null);
		
		System.err.println(output);
	}
}