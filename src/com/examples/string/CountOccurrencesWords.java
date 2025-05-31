package com.examples.string;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesWords {
	public static void main(String[] args) {
		countWordsMethod1();
	}

	public static void countWordsMethod1() {
		String input = "Hello world. Hello everyone!";
		Map<String, Integer> wordCountMap = new HashMap<>();

		String[] words = input.split(" ");

		for (String word : words) {
			word = word.toLowerCase();
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}

		System.out.println("Occurrences of each word:");
		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
