package com.examples.problems.stream;

import java.util.List;

public class FlatMap {

	static void withStream() {
		List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(6, 7, 8));

		int sum = list.stream().flatMap(List::stream).mapToInt(in -> in).sum();

		System.out.println(sum);
	}

	public static void main(String[] args) {
		withStream();
	}
}