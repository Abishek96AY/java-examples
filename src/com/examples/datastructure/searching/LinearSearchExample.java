package com.examples.datastructure.searching;

/**
    1. Start from the Beginning: Begin by checking the first element of the array.
    2. Check Each Element: Move through the array, comparing each element to the target value.
        ◦ If you find the target, stop and return the position.
        ◦ If you reach the end of the array without finding the target, conclude that the target is not present.
 **/

public class LinearSearchExample {
	public static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {  // Check if the current element is the target
				return i;  // Target found, return its index
			}
		}
		return -1;  // Target not found
	}

	public static void main(String[] args) {
		int[] array = {4, 2, 7, 1, 9, 3};
		int target = 7;
		int result = linearSearch(array, target);

		if (result != -1) {
			System.out.println("Element found at index: " + result);
		} else {
			System.out.println("Element not found");
		}
	}
}