package com.examples.problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountOccurrencesWords {
	public static void main(String[] args) {
		countWordsMethod3();
	}

	public static void countWordsMethod1() {
		String input = "Hello world. Hello everyone!";
		String[] words = input.split(" ");

		Map<String, Integer> wordCountMap = new HashMap<>();
		for (String word : words) {
			word = word.toLowerCase();
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}

		System.out.println("Occurrences of each word:");
		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public static void countWordsMethod2() {
		String input = "Hello world. Hello everyone!";

		// Split by whitespace
		String[] words = input.split("\\s+");

		// Convert array to ArrayList
		ArrayList<String> list = new ArrayList<>(Arrays.asList(words));

		Map<String, Long> wordCountMap = list.stream()
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));

		System.out.println(wordCountMap);
	}

	public static void countWordsMethod3() {
		String str = "Hello world. Hello everyone!";
		String[] strArr = Pattern.compile("\\W+").split(str);
		
		Map<String, Long> map = Arrays.stream(strArr)
				.map(/* word -> word.toLowerCase() */ String::toLowerCase) // convert to lowercase
				.collect(Collectors.groupingBy(word -> word, /* LinkedHashMap::new, */Collectors.counting()));
		
		map.forEach((Word, Count) -> System.out.println("Word :: "+Word +", Count :: "+Count));
	}
}