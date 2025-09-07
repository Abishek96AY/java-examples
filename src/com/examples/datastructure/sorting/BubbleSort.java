package com.examples.datastructure.sorting;

public class BubbleSort {
	/**
	 * Bubble Sort • Concept: Repeatedly steps through the list, compares adjacent
	 * elements, and swaps them if they are in the wrong order. • Time Complexity:
	 * O(n^2)
	 */

	public static void main(String[] args) {

	}

	public static void bubbleSort1() {
		int[] arr = { 5, 3, 8, 4, 2 };

		// Bubble Sort
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j] and arr[j+1]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		// Print sorted array
		for (int n : arr) {
			System.out.print(n + " ");
		}
	}

	static void bubbleSortUserDefined(int[] arr, boolean ascending) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1]) {
					// swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}