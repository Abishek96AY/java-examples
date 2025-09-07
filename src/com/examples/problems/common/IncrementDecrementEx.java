package com.examples.problems.common;

class X 
{
	static int i = 1111;

	static
	{
		System.out.println("I :: "+i);

		//System.out.println("I1 :: "+i--);
		//System.out.println("I2 :: "+--i);

		i = i-- - --i;    //L1
		
		System.out.println("1 :: "+i);
	}

	{
		//System.out.println("I3 :: "+ i++);
		//System.out.println("I4 :: "+ ++i);
		i = i++ + ++i;    //L2

		System.out.println("2 :: "+i);
	}
}

class Y extends X{
	static{
		//System.out.println("I5 :: "+ --i);
		//System.out.println("I6 :: "+ i--);
		i = --i - i--;    //L3

		System.out.println("3 :: "+i);
	}
	{
		//System.out.println("I5 :: "+ ++i);
		//System.out.println("I6 :: "+ i++);
		i = ++i + i++;    //L4

		System.out.println("4 :: "+i);
	}
}

public class IncrementDecrementEx
{
	public static void main(String[] args){
		Y y = new Y();
		System.out.println(y.i);    //L5
	}
}