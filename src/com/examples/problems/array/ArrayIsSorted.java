package com.examples.problems.array;

import java.util.stream.IntStream;

public class ArrayIsSorted {

	public static void main(String[] args) {

		int[] arr = { 10, 5, 20, 8, 20, 15 };
		boolean sorted = true;

		// Without Stream
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				sorted = false;
				break;
			}
		}
		System.err.println("Without Stream : "+sorted);

		// With Stream
		sorted = IntStream.range(0, arr.length - 1).allMatch(i -> arr[i] <= arr[i + 1]);
		System.err.println("With Stream : "+sorted);
	}
}