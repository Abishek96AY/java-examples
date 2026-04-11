package com.examples.problems.array;

import java.util.Arrays;

public class SecondLargestInArray {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 8, 12 };

		// Without Stream
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

		for (int i : arr) {
			if (i > first) {
				second = first;
				first = i;
			} else if (i > second && i != first) {
				second = i;
			}
		}

		System.out.println("Second largest: " + second);

		// With Stream
		second = Arrays.stream(arr)
				.distinct()
				.boxed()
				.sorted((a, b) -> b - a)
				.skip(1)
				.findFirst()
				.orElseThrow();

		System.out.println("Second largest: " + second);
	}
}