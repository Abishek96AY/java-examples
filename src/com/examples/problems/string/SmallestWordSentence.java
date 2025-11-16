package com.examples.problems.string;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SmallestWordSentence {
	public static void main(String[] args) {
		String input = "Java is amazing";
		
		withOutStream(input);
		withStream(input);
	}

	static void withOutStream(String input) {
		String[] words = input.split("\\s+");
		
		if (words.length == 0) {
	        System.out.println("");  // no words
	        return;
	    }

	    String smallest = words[0];  // start with the first word
	    for (String word : words) {
	        if (word.length() < smallest.length()) {
	            smallest = word;
	        }
	    }
	    System.out.println(smallest);
	}

	static void withStream(String input) {
		String output = Arrays.stream(input.split("\\s+"))
				.collect(Collectors.toMap(e -> e, e -> e.length()))
				.entrySet()
				.stream()
				.min(Map.Entry.comparingByValue())
				.map(e -> e.getKey())
				.orElse("");
		
		System.err.println(output);
	}
}