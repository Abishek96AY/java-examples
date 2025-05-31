package com.examples.inheritance;


/*
 * Hierarchical Inheritance: Multiple derived classes inherit from a single base class.
 */

class Animal3
{
	String type = "NA";

	String weight = "NA";

	void type()
	{
		System.out.println("Animal Type :: "+type);
	}

	void weight()
	{
		System.out.println("Animal Weight :: "+weight);
	}
}

class Status2 extends Animal3
{
	void conservationStatus(String conservationStatus)
	{
		System.out.println("Conservation Status :: "+conservationStatus);
	}
}

class Tiger2 extends Animal3
{
	String eats = "";

	void eat(String name)
	{
		System.out.println(name+" Eats :: "+eats);
	}
}

public class HierarchicalInheritance
{
	public static void main(String[] args)
	{
		Tiger2 obj = new Tiger2();
		obj.type = "Carnivore";
		obj.eats = "Dear";
		obj.type();
		//obj.conservationStatus("Endangered"); // Compile Time Error
		obj.eat("Tiger");
	}
}