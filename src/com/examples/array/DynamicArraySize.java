package com.examples.array;

import java.util.Arrays;

public class DynamicArraySize {
	private int[] array;

	private int size;

	public DynamicArraySize() {
		array = new int[10]; // Default initial capacity
		size = 0;
	}

	public void add(int element) {
		// Check if the array is full
		if (size == array.length) {
			// Double the size of the array
			array = Arrays.copyOf(array, array.length * 2);
		}
		// Add the new element
		array[size++] = element;
	}

	void show() {
		System.err.println("Size :: " + array.length);

		for (int i : array) {
			System.out.println("Array :: "+array[i]);
		}
	}

	public static void main(String[] args) {
		DynamicArraySize list = new DynamicArraySize();
		for (int i = 0; i < 25; i++) {
			list.add(i);
		}
		list.show();
	}
}