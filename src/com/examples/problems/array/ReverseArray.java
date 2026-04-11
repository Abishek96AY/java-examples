package com.examples.problems.array;

import java.util.stream.IntStream;

public class ReverseArray {

	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50, 70, 90, 88 };
		reverseWithStream(array);
	}

	public static void reverseArray(int[] array) {
		int startIndex = 0;
		int endIndex = array.length - 1;

		while (startIndex < endIndex) {
			System.out.println("startIndex :: " + startIndex + ", endIndex :: " + endIndex);
			// Swap the values
			int temp = array[startIndex];
			array[startIndex] = array[endIndex];
			array[endIndex] = temp;

			// Move indices towards the center
			startIndex++;
			endIndex--;
		}
		
		System.out.println("Reversed array:");
		for (int num : array) {
			System.out.print(num + " ");
		}
	}

	static void reverseWithStream(int[] array) {
		int[] reversed = IntStream.range(0, array.length).map(i -> array[array.length - 1 - i]).toArray();
		
		System.out.println("Reversed array with stream:");
		for (int num : reversed) {
			System.out.print(num + " ");
		}
	}
}