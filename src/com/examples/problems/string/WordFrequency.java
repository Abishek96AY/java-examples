package com.examples.problems.string;

import java.util.*;
import java.util.stream.*;

public class WordFrequency {
	public static void main(String[] args) {
		String input = "epam java interview java question epam";

		Map<String, Long> freq = Arrays.stream(input.split(" "))
				.collect(Collectors.groupingBy(w -> w, Collectors.counting()));

		System.out.println(freq);
	}
}