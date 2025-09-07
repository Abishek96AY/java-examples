package com.examples.datastructure.stack;

class StackEx1
{
	int[] array;
	int top, capacity;

	public StackEx1(int capacity)
	{
		array = new int[capacity];
		top = -1;
		this.capacity = capacity;
	}

	boolean isArrayEmpty()
	{
		return top == -1;
	}

	boolean isArrayFull()
	{
		return top >= capacity - 1;
	}


	void push(int a)
	{
		if (!isArrayFull())
		{
			array[++top] = a;
		}
		else
		{
			System.out.println("Array Is Full !!!");
		}
	}

	int pop()
	{
		if (!isArrayEmpty())
		{
			int popItem = array[top];
			array[top--] = 0;
			return popItem;
		}
		else
		{
			System.out.println("Array Is Empty !!!");
			return -1;
		}
	}

	int peek()
	{
		if (!isArrayEmpty()) 
		{
			return array[top];  // Return the top element without removing it
		}
		else
		{
			System.out.println("Array Is Empty !!!");
			return -1;  // Indicate that the stack is empty
		}
	}

	void display()
	{
		for (int i = 0; i <=top; i++)
		{
			System.out.println("array :: "+array[i]);
		}
	}
}

public class StackUsingArrayEx1
{
	public static void main(String[] args)
	{
		StackEx1 obj = new StackEx1(5);
		obj.push(10);
		obj.push(20);
		obj.push(30);
		//System.err.println("Popped Item :: "+obj.pop());
		obj.display();
	}
}