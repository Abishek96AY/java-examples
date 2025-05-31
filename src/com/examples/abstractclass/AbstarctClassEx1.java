package com.examples.abstractclass;

abstract class AbsClass
{
	String str = "";
	
	public AbsClass(String str) {
		this.str = str;
	}
	
	abstract void abc();

	void test()
	{
		System.err.println(str+ "Test !!!");
	}
}

public class AbstarctClassEx1 extends AbsClass
{
	public AbstarctClassEx1(String test) {
		super(test);
	}

	public static void main(String[] args)
	{
		AbstarctClassEx1 obj = new AbstarctClassEx1("Hello : ");
		obj.test();
		obj.abc();
	}

	@Override
	void abc() {
		System.out.println("Abc !!!");
	}
}