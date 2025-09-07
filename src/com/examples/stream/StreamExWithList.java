package com.examples.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExWithList {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 10, 9, 8, 7, 6);
		list.forEach(System.out::println);
		System.out.println("****************************************************************************");

		List<Integer> filteredList = list.stream().filter(e -> e % 2 == 0).toList();
		filteredList.forEach(System.out::println);
		System.out.println("****************************************************************************");

		List<Integer> transformedList = list.stream().map(e -> e * 2).toList();
		transformedList.forEach(System.out::println);
		System.out.println("****************************************************************************");

		long count = list.stream().count();
		System.out.println("Count :: " + count);
		System.out.println("****************************************************************************");

		List<Integer> sortedList = list.stream().sorted().toList();
		System.out.println(sortedList);
		System.out.println("****************************************************************************");

		List<Integer> revSortedList = list.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println(revSortedList);
		System.out.println("****************************************************************************");
		
		List<String> listEx = Arrays.asList("100", "ABC", "1AB", "101");
		List<Integer> numericOnly = listEx.stream()
		        .filter(s -> s.matches("\\d+"))
		        .map(Integer::parseInt)
		        .collect(Collectors.toList());
		System.out.println(numericOnly);
		System.out.println("****************************************************************************");
	}
}