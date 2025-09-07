package com.examples.syntax;

import java.util.Optional;

public class OptionalClassExample {
	public static void main(String[] args) {
		// Case 1: Optional with a non-null value
		Optional<String> name = Optional.of("Abishek");
		System.out.println("Name: " + name.get()); // prints "Abishek"

		// Case 2: Optional that may contain null (use ofNullable)
		Optional<String> maybeName = Optional.ofNullable(null);
		System.out.println("Is present? " + maybeName.isPresent()); // false

		// Case 3: Providing default value if empty
		String defaultName = maybeName.orElse("Guest");
		System.out.println("Name with default: " + defaultName); // Guest

		// Case 4: Using lambda with ifPresent
		name.ifPresent(n -> System.out.println("Hello, " + n));

		// Case 5: Transforming value with map
		Optional<Integer> nameLength = name.map(String::length);
		System.out.println("Name length: " + nameLength.orElse(0)); // 7
	}
}