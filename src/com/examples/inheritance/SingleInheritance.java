package com.examples.inheritance;

/*
 * Single Inheritance: A class can inherit from only one superclass.
 */

class Animal
{
	String type = "NA";

	void type()
	{
		System.out.println("Type :: "+this.type);
	}
}

class Lion extends Animal
{
	String sound = "Roar";

	void sound()
	{
		System.out.println("Sound :: "+sound);
	}
}

public class SingleInheritance
{
	public static void main(String[] args)
	{
		Lion obj = new Lion();
		obj.type = "Carnivore";
		obj.type();
		obj.sound();
	}
}