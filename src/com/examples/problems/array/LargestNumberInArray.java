package com.examples.problems.array;

import java.util.Arrays;

public class LargestNumberInArray {
	public static void main(String[] args) {
		int arr[] = { 10, 10, 12, 13, 334, 756, 10, 123 };
		int max = arr[0];

		// Without Stream
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		System.out.println("Without Stream Max :: " + max);

		// With Stream
		max = Arrays.stream(arr).max().getAsInt();
		System.out.println("With Stream Max :: " + max);
	}
}