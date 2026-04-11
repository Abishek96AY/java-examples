package com.examples.problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequencyEachElement {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 8, 20, 15 };
		
		// Without Stream
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		System.out.println("Without Stream : "+map);

		// With Stream
		Map<Integer, Long> freq = Arrays.stream(arr)
				.boxed()
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		System.out.println("With Stream : "+freq);
	}
}