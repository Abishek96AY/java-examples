package com.examples.string;

import java.util.Arrays;
import java.util.List;

public class RegexFilterExample {
	public static void main(String[] args) {
		List<String> listEx = Arrays.asList("100", "-25", "12.5", "ABC", "1AB", "101", "$#@", "45.0");

		List<String> integers = listEx.stream().filter(s -> s.matches("^-?\\d+$")).toList();

		List<String> decimals = listEx.stream().filter(s -> s.matches("^-?\\d*\\.\\d+$")).toList();

		List<String> alphabets = listEx.stream().filter(s -> s.matches("^[A-Za-z]+$")).toList();

		List<String> alphanumerics = listEx.stream().filter(s -> s.matches("^[A-Za-z0-9]+$")).toList();

		List<String> specials = listEx.stream().filter(s -> s.matches("^[^A-Za-z0-9]+$")).toList();

		System.out.println("Integers: " + integers);
		System.out.println("Decimals: " + decimals);
		System.out.println("Alphabets: " + alphabets);
		System.out.println("Alphanumerics: " + alphanumerics);
		System.out.println("Specials: " + specials);
	}
}