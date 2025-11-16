package com.examples.problems.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountAllDuplicateWords {

	public static void main(String[] args) {
		String input = "Java is a widely used programming language. Java is a versatile and java has a large community.";
		withOutStream(input);
		withStream(input);
	}

	public static void withOutStream(String input) {
		String[] words = input.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
		Map<String, Integer> wordCountMap = new LinkedHashMap<>();

		for (String word : words) {
			String wordLowerCase = word.toLowerCase();
			wordCountMap.put(wordLowerCase, wordCountMap.getOrDefault(wordLowerCase, 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " : " + entry.getValue() + " times");
			}
		}
	}

	public static void withStream(String input) {
		Map<String, Long> map = Arrays.stream(input.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+"))
				.map(String::toLowerCase)
				.collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

		map.forEach((a, b) -> {
				System.out.println(a + " - " + b);
		});
	}
}