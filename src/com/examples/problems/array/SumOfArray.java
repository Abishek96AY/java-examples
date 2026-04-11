package com.examples.problems.array;

import java.util.Arrays;

public class SumOfArray {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 8, 20, 15 };
		int sum = 0;
		
		// Without Stream
		for (int i : arr) {
			sum = sum + i;
		}
		System.out.println("Without Stream :: "+sum);
		
		// With Stream
		sum = Arrays.stream(arr).sum();
		System.out.println("With Stream :: "+sum);
	}
}