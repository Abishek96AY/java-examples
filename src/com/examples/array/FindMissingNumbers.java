package com.examples.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FindMissingNumbers {
	public static void main(String[] args) {
		int[] arr = { 7, 1, 100, 2, 8, 3 };

		// Store in TreeSet for sorting + unique elements
		TreeSet<Integer> set = new TreeSet<>();
		for (int num : arr) {
			set.add(num);
		}

		List<Integer> missingNumbers = new ArrayList<>();

		// Get min and max from TreeSet
		/*int min = set.first();
		int max = set.last();

		for (int i = min; i <= max; i++) {
			if (!set.contains(i)) {
				missingNumbers.add(i);
			}
		}*/
		
		// Iterate over consecutive elements in TreeSet
        Integer prev = null;
        for (Integer current : set) {
            if (prev != null && current - prev > 1) {
                for (int i = prev + 1; i < current; i++) {
                    missingNumbers.add(i);
                }
            }
            prev = current;
        }

		System.out.println("Missing Numbers: " + missingNumbers);
	}
}