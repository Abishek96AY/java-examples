package com.examples.problems.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedElement {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 8, 20, 15 };

		// Without Stream
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i : arr)
			map.put(i, map.getOrDefault(i, 0) + 1);

		for (var e : map.entrySet())
			if (e.getValue() == 1) {
				System.out.println(e.getKey());
				break;
			}

		// With Stream
		int firstUnique = Arrays.stream(arr)
				.boxed()
				.collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
		System.out.println(firstUnique);
	}
}