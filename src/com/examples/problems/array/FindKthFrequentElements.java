package com.examples.problems.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindKthFrequentElements {
	static void withStream() {
		int arr[] = { 1, 1, 1, 2, 2, 3, 3 };
		int in = 2;
		
		List<Integer> list = Arrays.stream(arr)
				.boxed()
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.map(e -> e.getKey())
				.limit(in)
				.toList();
		
		list.forEach(System.out::println);
	}
}
