package com.examples.array;

public class CheckTwoArraysAreEqual {
	public static void main(final String[] args) {

		final int[] array1 = { 1, 2, 3, 4, 5 };
		final int[] array2 = { 1, 2, 3, 4, 5 };

		final boolean intCheck = equals(array1, array2);
		System.out.println("Two Integers are Equal :: " + intCheck);
	}

	public static boolean equals(final int[] a, final int[] a2) {
		if (a == a2)
			return true;

		if (a == null || a2 == null)
			return false;

		final int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}
}