package com.examples.logical;

public class PrimeNumberWithinRange
{
	public static void main(String[] args)
	{
		int start = 10; // Start of the range
		int end = 50; // End of the range
		System.out.println("Prime numbers between " + start + " and " + end + ":");

		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}

	// Method to check if a number is prime
	public static boolean isPrime(int number) {
		if (number <= 1) {
			return false; // Numbers less than or equal to 1 are not prime
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false; // Found a divisor other than 1 and the number itself
			}
		}
		return true; // No divisors found, so it's prime
	}
}