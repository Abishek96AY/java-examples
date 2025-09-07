package com.examples.datastructure.linkedlist;

class Node
{	
	int data;
	Node next;

	Node(int d)
	{
		this.data = d;
		this.next = null;
	}
}

public class SinglyLinkedListEx1
{
	Node head, tail;

	void insertAtBegin(int a)
	{
		Node obj = new Node(a);
		obj.next = head;
		head = obj;
	}
	
	void insertAtEnd(int a)
	{
		Node obj = new Node(a);
		if (head == null)
		{
			head = obj;
			tail = obj;
		}
		else
		{
			tail.next = obj;
			tail = obj;
		}
	}

	void insertAtPosition(int a, int pos)
	{
		Node obj = new Node(a);
		if (pos == 1)
		 {
			obj.next = head;
			head = obj;
			return;
		}

		Node temp = head;
		for (int i = 0; i < pos-1 && temp != null; i++)
		{
			temp = temp.next;
		}

		if (temp != null)
		{
			obj.next = temp.next;
			temp.next = obj;
		}
		else
		{
			System.out.println("Position out of bounds");
		}
	}
	
	void deleteAtBeign()
	{
		head = head.next;
	}
	
	void deleteAtEnd()
	{
		Node temp = head;
		while(temp.next != tail)
		{
			temp = temp.next;
		}
		temp.next = null;
		tail = temp;
	}
	
	void deleteAtPosition(int pos)
	{
		Node temp = head;
		for (int i = 0; i < pos - 1; i++)
		{
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}

	void display()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.println("Data : "+temp.data);
			temp = temp.next;
		}
		System.out.println("*****************************************************************");
	}

	public static void main(String[] args)
	{
		SinglyLinkedListEx1 list = new SinglyLinkedListEx1();
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.insertAtBegin(5);
		list.insertAtPosition(15, 0);
		list.display();
		//list.deleteAtBeign();
		//list.deleteAtEnd();
		list.deleteAtPosition(2);
		list.display();
	}
}