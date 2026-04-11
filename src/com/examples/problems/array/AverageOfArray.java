package com.examples.problems.array;

import java.util.Arrays;

public class AverageOfArray {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 8, 20, 15 };
		int sum = 0;
		
		// Without Stream
		for (int i : arr) {
			sum = sum + i;
		}
		double avg = (double) sum / arr.length;
		System.out.println("Without Stream :: "+avg);
		
		// With Stream
		sum = Arrays.stream(arr).sum();
		avg = Arrays.stream(arr).average().getAsDouble();
		System.out.println("With Stream :: "+avg);
	}
}