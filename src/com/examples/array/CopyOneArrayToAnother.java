package com.examples.array;

public class CopyOneArrayToAnother
{
	public static void main(String[] args)
	{
		int[] oldArray = {1, 2, 3, 4, 5};
		int[] newArray = new int[oldArray.length * 2];
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);

		for (int i : newArray)
		{
			System.out.println(i);
		}
	}
}