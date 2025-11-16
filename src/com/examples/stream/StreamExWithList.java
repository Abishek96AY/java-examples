package com.examples.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamExWithList {
	public static void main(String[] args) {

		// Example: List of lists -> flatten into single list
		List<List<String>> nestedList = Arrays.asList(
				Arrays.asList("A", "B"), 
				Arrays.asList("C", "D"),
				Arrays.asList("E", "F"));
		List<String> flatList = nestedList.stream().flatMap(List::stream).toList();
		System.out.println("Flat list: " + flatList); // [A, B, C, D, E, F]
		System.out.println("****************************************************************************");
		
		List<String> stringList = List.of("John", "Alice", "Bob");
		
		List<String> upperCase = stringList.stream()
		        .map(String::toUpperCase) // convert to UPPERCASE
		        .sorted()                 // sort alphabetically
		        .toList();
		
		
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 10, 9, 8, 7, 6);
		
		int sum = integerList.stream().mapToInt(Integer::intValue).sum();
		double avg = integerList.stream().mapToInt(Integer::intValue).average().orElse(0);
		int secondHighest = integerList.stream()
		        .distinct()
		        .sorted(Comparator.reverseOrder())
		        .skip(1)
		        .findFirst()
		        .orElseThrow();

		
		int sumUsingReduce = integerList.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sumUsingReduce);
		System.out.println("****************************************************************************");

		int max = integerList.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		System.out.println(max);
		System.out.println("****************************************************************************");

		integerList.forEach(System.out::println);
		System.out.println("****************************************************************************");

		List<Integer> filteredList = integerList.stream().filter(e -> e % 2 == 0).toList();
		filteredList.forEach(System.out::println);
		System.out.println("****************************************************************************");

		List<Integer> transformedList = integerList.stream().map(e -> e * 2).toList();
		transformedList.forEach(System.out::println);
		System.out.println("****************************************************************************");

		long count = integerList.stream().count();
		System.out.println("Count :: " + count);
		System.out.println("****************************************************************************");

		List<Integer> sortedList = integerList.stream().sorted().toList();
		System.out.println(sortedList);
		System.out.println("****************************************************************************");

		List<Integer> revSortedList = integerList.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println(revSortedList);
		System.out.println("****************************************************************************");

		List<String> listEx = Arrays.asList("100", "ABC", "1AB", "101");
		List<Integer> numericOnly = listEx.stream()
				.filter(s -> s.matches("\\d+"))
				.map(Integer::parseInt)
				.toList();
		System.out.println(numericOnly);
		System.out.println("****************************************************************************");

		List<String> strList = Arrays.asList("a", "b", "c");
		String result = strList.stream().reduce("", (a, b) -> a + b);
		System.out.println(result);
		System.out.println("****************************************************************************");
		
		List<String> names = List.of("Alice", "Bob", "Charlie");

		List<String> listNames = names.stream()
		    .peek(n -> System.out.println("Before filter: " + n))
		    .filter(n -> n.startsWith("A"))
		    .peek(n -> System.out.println("After filter: " + n))
		    .map(String::toUpperCase)
		    .toList();
	}
}