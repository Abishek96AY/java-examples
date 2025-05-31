package com.examples.array;

import java.util.HashSet;

public class FindMissingNumber {
	public static int findMissingNumber(int[] arr, int n) {
		HashSet<Integer> hashSet = new HashSet<Integer>(); 
		      // Add all elements of array to hashset
		    for (int i = 0; i < n-1; i++) {
		        hashSet.add(arr[i]);
		    }

		    // Check each integer from 1 to n
		    for (int i = 1; i <= n; i++) {
		        // If integer is not in hashset, it is the missing integer
		        if (!hashSet.contains(i)) {
		            return i;
		        }
		    }

		    // If no integer is missing, return n+1
		    return n+1;
		}

		public static void main(String[] args) {
		    int[] arr = {1, 2, 4, 6, 3, 7, 8};
		    int n = arr.length;

		    int missingNumber = findMissingNumber(arr, n);
		    System.out.println("Missing number is: " + missingNumber);
		}
}
