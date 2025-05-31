package com.examples.sorting;

public class SelectionSort
{
	/**
	 * Selection Sort
	 * • Concept: Repeatedly finds the minimum element from the unsorted part and puts it at the beginning.
	 * • Time Complexity: O(n^2)
	 */

	public static void main(String[] args) {
		int[] arr = {29, 10, 14, 37, 13, 1, 4};

		// Perform Selection Sort
		selectionSort(arr);

		// Print the sorted array
		System.out.println("Sorted array: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	// Selection Sort function
	public static void selectionSort(int[] arr) {
		int n = arr.length;

		// Loop through the entire array
		for (int i = 0; i < n - 1; i++) {
			// Assume the first element of the unsorted part as the minimum
			int minIndex = i;

			// Find the smallest element in the unsorted part
			for (int j = i + 1; j < n; j++) {
				System.out.println("arr[j] :: "+arr[j]+", arr[minIndex] :: "+arr[minIndex]);
				if (arr[j] < arr[minIndex]) {
					minIndex = j;  // Update minIndex if a smaller element is found
				}
			}

			// Swap the smallest element with the first element of the unsorted part
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;

			// Print the array after each pass to show progress
			System.out.print("Array after pass " + (i + 1) + ": ");
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}