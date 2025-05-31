package com.examples.searching;


/**
    1. Start with the Middle: Begin by checking the middle element of the array.
    2. Compare the Target: Compare the target value to the middle element.
        ◦ If the target value is equal to the middle element, you've found it!
        ◦ If the target value is smaller, the target must be in the left half of the array.
        ◦ If the target value is larger, the target must be in the right half of the array.
    3. Narrow the Search: Repeat the process for the relevant half of the array until you find the target or the search space is empty.
 **/

public class BinarySearchExample {
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {

			//int mid = left + (right - left) / 2; // This is the preferred and safer method for calculating the middle index in a binary search, as it avoids potential overflow issues.

			int mid = (left + right) / 2; // Find the middle element

			System.out.println("Mid :: "+mid);

			if (arr[mid] == target) {
				return mid; // Target found, return its index
			} 
			else if (arr[mid] < target) {
				left = mid + 1; // Search in the right half
			} else {
				right = mid - 1; // Search in the left half
			}
		}
		return -1; // Target not found
	}

	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 11, 13};
		int target = 13;
		int result = binarySearch(array, target);

		if (result != -1) {
			System.out.println("Element found at index: " + result);
		} else {
			System.out.println("Element not found");
		}
	}
}