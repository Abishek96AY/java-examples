package com.examples.array;

public class LargestNumberFinderInArray {
	public static void main(String[] args) {
		int arr[] = {10, 10, 12, 13, 334, 756, 10, 123};
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= max) {
				max = arr[i];
			}
		}
		System.out.println("Max :: "+max);
	}
}