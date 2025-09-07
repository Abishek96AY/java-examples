package com.examples.datastructure.stack;

//Node class to represent each element in the linked list
class Node {
	int data;
	Node next;

	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

//Stack class using a linked list
class Stack
{
	private Node top;

	// Constructor to initialize the stack
	public Stack() {
		this.top = null;
	}

	// Push operation to add an element to the top of the stack
	public void push(int x) {
		Node newNode = new Node(x);
		newNode.next = top;
		top = newNode;
		System.out.println("Inserted " + x);
	}

	// Pop operation to remove and return the top element from the stack
	public int pop()
	{
		if (isEmpty())
		{
			System.out.println("Stack Underflow");
			return -1;
		}
		int poppedValue = top.data;
		top = top.next;
		return poppedValue;
	}

	// Peek operation to return the top element of the stack without removing it
	public int peek()
	{
		if (isEmpty())
		{
			System.out.println("Stack is empty");
			return -1;
		}
		return top.data;
	}

	// Method to check if the stack is empty
	public boolean isEmpty()
	{
		return top == null;
	}

	// Method to get the size of the stack
	public int size()
	{
		int count = 0;
		Node current = top;
		while (current != null)
		{
			count++;
			current = current.next;
		}
		return count;
	}
}

//Example usage of the stack
public class StackUsingLinkedListEx1
{
	public static void main(String[] args)
	{
		Stack stack = new Stack();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("Top element is: " + stack.peek());

		stack.pop();
		System.out.println("Top element after pop is: " + stack.peek());

		System.out.println("Stack size is: " + stack.size());

		stack.pop();
		stack.pop();
		stack.pop();  // This will cause stack underflow
	}
}