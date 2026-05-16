package com.examples.problems.array;

import java.util.Arrays;

public class SmallestNumberInArray {
	public static void main(String[] args) {
		int arr[] = { 10, -11, 20, 30, -412, 3, -5 };
		int min = arr[0];

		// Without Stream
		for (int i : arr) {
			if (i < min) {
				min = i;
			}
		}
		System.out.println("Without Stream Min " + min);
		
		// With Stream
		min = Arrays.stream(arr).min().getAsInt();
		System.out.println("With Stream Min " + min);
	}
}