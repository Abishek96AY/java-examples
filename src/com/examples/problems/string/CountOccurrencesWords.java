package com.examples.problems.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurrencesWords {
	public static void main(String[] args) {
		String input = "Hello world. hello    everyone!";
		withOutStream(input);
		withStream(input);
	}

	public static void withOutStream(String input) {
		input = input.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
		String[] words = input.split("\\s+");
		Map<String, Integer> wordCountMap = new LinkedHashMap<>();
		for (String word : words) {
			word = word.toLowerCase();
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}
		System.out.println("Occurrences of each word:");
		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public static void withStream(String input) {
		input = input.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
		String[] words = input.split("\\s+");
		Map<String, Long> map = Arrays.stream(words).map(/* word -> word.toLowerCase() */ String::toLowerCase)
				.collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()));

		map.forEach((Word, Count) -> System.out.println("Word :: " + Word + ", Count :: " + Count));
	}
}