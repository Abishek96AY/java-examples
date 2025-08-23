package com.examples.string;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateWords {

	static String sentence = "Java is a programming language and Java is also a platform";

	public static void main(String[] args) {
		method2();
	}

	public static void method1() {
		Set<String> obj = new LinkedHashSet<>();
		String[] strArr = sentence.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			for (int j = i + 1; j < strArr.length; j++) {
				if (strArr[i].equals(strArr[j])) {
					obj.add(strArr[i]);
				}
			}
		}
		System.out.println(obj);
	}

	public static void method2() {
		String[] words = sentence.split(" ");
		Map<String, Integer> wordCountMap = new HashMap<>();

		for (String word : words) {
			String wordLowerCase = word.toLowerCase();
			wordCountMap.put(wordLowerCase, wordCountMap.getOrDefault(wordLowerCase, 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
			}
		}
	}
}