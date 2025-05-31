package com.examples.lambda;

interface Addable{  
	int add(int a, int b);  
}

public class LambdaExpressionExample5{  
	public static void main(String[] args) {
		// Multiple parameters in lambda expression with concise way
		Addable ad1 = (a,b) -> (a+b);
		System.out.println(ad1.add(10,20));

		// Multiple parameters in lambda expression with block of code way
		Addable ad2 = (a,b) -> {
			return a+b;
		};
		System.out.println(ad2.add(10,20));

		// Multiple parameters with data type in lambda expression  
		Addable ad3 = (int a, int b) -> (a+b);
		System.out.println(ad3.add(100,200));
	}
}  