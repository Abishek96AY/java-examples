package com.examples.problems.array;

import java.util.Arrays;

public class ArraysUtilitiesExample {
	public static void main(String[] args) {
		// ---------------- 1. Arrays.toString() ----------------
		int[] nums = { 5, 2, 9, 1, 7 };
		System.out.println("Original Array: " + Arrays.toString(nums));

		// ---------------- 2. Arrays.sort() ----------------
		Arrays.sort(nums);
		System.out.println("Sorted Array: " + Arrays.toString(nums));

		// ---------------- 3. Arrays.binarySearch() ----------------
		int index = Arrays.binarySearch(nums, 7); // must be sorted before using
		System.out.println("Index of 7: " + index);

		// ---------------- 4. Arrays.equals() ----------------
		int[] numsCopy = { 1, 2, 5, 7, 9 };
		System.out.println("Arrays equal? " + Arrays.equals(nums, numsCopy));

		// ---------------- 5. Arrays.copyOf() ----------------
		int[] copyArray = Arrays.copyOf(nums, 3); // copy first 3 elements
		System.out.println("Copy of first 3: " + Arrays.toString(copyArray));

		// ---------------- 6. Arrays.copyOfRange() ----------------
		int[] rangeArray = Arrays.copyOfRange(nums, 1, 4); // index 1 to 3
		System.out.println("Copy range [1..3]: " + Arrays.toString(rangeArray));

		// ---------------- 7. Arrays.fill() ----------------
		int[] fillArray = new int[5];
		Arrays.fill(fillArray, 42);
		System.out.println("Filled Array: " + Arrays.toString(fillArray));

		// ---------------- 8. Arrays.mismatch() (Java 9+) ----------------
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 9, 4, 5 };
		int mismatchIndex = Arrays.mismatch(arr1, arr2);
		System.out.println("First mismatch index: " + mismatchIndex);

		// ---------------- 9. Arrays.parallelSort() (faster for large arrays) ----------------
		int[] bigArray = { 50, 20, 10, 40, 30 };
		Arrays.parallelSort(bigArray);
		System.out.println("Parallel Sorted Array: " + Arrays.toString(bigArray));

		// ---------------- 10. Arrays.stream() (Java 8+) ----------------
		int sum = Arrays.stream(nums).sum();
		System.out.println("Sum using Arrays.stream(): " + sum);

		// ---------------- 11. Arrays.deepToString() (for 2D arrays) ----------------
		int[][] matrix = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		System.out.println("2D Array: " + Arrays.deepToString(matrix));

		// ---------------- 12. Arrays.deepEquals() ----------------
		int[][] m1 = { { 1, 2 }, { 3, 4 } };
		int[][] m2 = { { 1, 2 }, { 3, 4 } };
		System.out.println("2D Arrays equal? " + Arrays.deepEquals(m1, m2));
	}
}