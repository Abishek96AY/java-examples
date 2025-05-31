package com.examples.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArrayList
{
	public static void method1()
	{
		final List<Integer> listWithDuplicates = new ArrayList<>();

		listWithDuplicates.add(10);
		listWithDuplicates.add(20);
		listWithDuplicates.add(30);
		listWithDuplicates.add(30);
		listWithDuplicates.add(50);
		listWithDuplicates.add(50);
		listWithDuplicates.add(10);

		System.out.println("Before removing duplicates :: " + Arrays.toString(listWithDuplicates.toArray()));

		final List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listWithDuplicates));

		System.out.println("After removing duplicates :: " + Arrays.toString(listWithoutDuplicates.toArray()));
	}

	public static void method2()
	{
		final List<Integer> listWithDuplicates = new ArrayList<>();

		listWithDuplicates.add(10);
		listWithDuplicates.add(20);
		listWithDuplicates.add(30);
		listWithDuplicates.add(30);
		listWithDuplicates.add(50);
		listWithDuplicates.add(50);
		listWithDuplicates.add(10);

		System.out.println("Before removing duplicates :: " + Arrays.toString(listWithDuplicates.toArray()));

		final List<Integer> listWithoutDuplicates = listWithDuplicates.stream().distinct().toList();

		System.out.println("After removing duplicates :: " + Arrays.toString(listWithoutDuplicates.toArray()));
	}

	public static void main(final String[] args)
	{	  
		method1();
	}
}