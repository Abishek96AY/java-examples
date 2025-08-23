package com.examples.interfaceex;

public class FunctionInterfaceWithAddTwoNum {
	public static void main(String args[]) {
		Abishek obj = (a, b) -> a + b;
		System.out.println(obj.add(10, 20));
	}
}

interface Abishek {
	int add(int a, int b);
}