package com.examples.problems.array;

import java.util.Arrays;

public class FindArrayContainsElement {
	public static void main(String[] args) {

		int[] arr = { 10, 5, 20, 8, 20, 15 };
		boolean found = false;
		int target = 105;

		// Without Stream
		for (int i : arr)
			if (i == target)
				found = true;
		System.err.println("Without Stream : "+found);

		// With Stream
		found = Arrays.stream(arr).anyMatch(i -> i == target);
		System.err.println("With Stream : "+found);
	}
}