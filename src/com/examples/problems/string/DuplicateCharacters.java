package com.examples.problems.string;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacters {
	static String str = "Java Guides Net";

	public static void main(String[] args) {
		method1();
		method2();
	}

	public static void method1() {
		Set<Character> setObj = new LinkedHashSet<>();

		char a[] = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					setObj.add(a[i]);
				}
			}
		}

		System.out.println("All Duplicates Found :: " + setObj);
	}

	public static void method2() {
		Map<Character, Integer> charCountMap = new LinkedHashMap<>();

		for (char c : str.toCharArray()) {
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print("Duplicate Found :: ," + entry.getKey() + " ");
			}
		}
	}
}