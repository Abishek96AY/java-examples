package com.examples.problems.common;

public class IntegerLogicPrograms
{
	static void sumOfArray()
	{
		int[] arr = new int[5];
		int sum = 0;
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println(sum);
	}
	
	static void oddOrEven()
	{
		int number = 10;
		if (number % 2 == 0)
		{
			System.out.println("Even !!!");
		}
		else
		{
			System.out.println("Odd !!!");
		}
	}
	
	public static void main(String[] args)
	{
		//sumOfArray();
		//oddOrEven();
	}
}