package com.examples.problems.common;

public class LargestOfThreeNumbers
{
	public static void main(String[] args)
	{
		int num1 = 10, num2 = 20, num3 = 30, largest = 0;

		if (num1 >= num2 && num1 >= num3) {
            largest = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            largest = num2;
        } else {
            largest = num3;
        }
		System.err.println("Largest of All :: "+largest);
	}
}