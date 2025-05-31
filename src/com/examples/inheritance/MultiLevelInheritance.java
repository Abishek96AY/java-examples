package com.examples.inheritance;

/*
 * Multilevel Inheritance: A derived class can act as a base class for another class.
 */

class Animal2
{
	String type = "NA";

	void type()
	{
		System.out.println("Animal Type :: "+type);
	}
}

class Status extends Animal2
{
	String conservationStatus = "NA";

	Status(String conservationStatus)
	{
		this.conservationStatus = conservationStatus;
	}

	void conservationStatus()
	{
		System.out.println("Conservation Status :: "+this.conservationStatus);
	}
}

class Tiger extends Status
{
	String eats = "";

	Tiger(String conservationStatus)
	{
		super(conservationStatus);
	}

	void eat(String name)
	{
		System.out.println(name+" Eats :: "+eats);
	}
}

public class MultiLevelInheritance
{
	public static void main(String[] args)
	{
		Tiger obj = new Tiger("Endangered");
		obj.type = "Carnivore";
		obj.eats = "Deer";
		obj.type();
		obj.conservationStatus();
		obj.eat("Tiger");
	}
}