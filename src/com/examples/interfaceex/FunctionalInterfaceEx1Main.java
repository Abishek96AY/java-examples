package com.examples.interfaceex;

public class FunctionalInterfaceEx1Main
{
	public static void main(String[] args)
	{
		FunctionalInterfaceEx1 obj = (a) -> {
			System.err.println("Test :: "+a);
		};

		obj.run("Working");
		obj.defaultMethod();
		FunctionalInterfaceEx1.staticMethod();
	}
}