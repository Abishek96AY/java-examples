package com.examples.sorting;

public class BubbleSort
{
	/**
	 * Bubble Sort
	 * • Concept: Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
	 * • Time Complexity: O(n^2)
	 */

	static int arr[] = {10, 20, 50, 40, 30};

	static void bubbleSort()
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = 0; j < arr.length - i - 1; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	static void showBubbleSortData()
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println("arr[] :: "+arr[i]);
		}
	}

	public static void main(String[] args)
	{
		bubbleSort();
		showBubbleSortData();
	}
}