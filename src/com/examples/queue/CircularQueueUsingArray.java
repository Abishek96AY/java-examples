package com.examples.queue;

class CircularQueueUsingArray
{
	private int[] arr;  // Array to store queue elements
	private int front;  // Points to the front element in the queue
	private int rear;   // Points to the last element in the queue
	private int capacity; // Maximum capacity of the queue
	private int count;  // Current size of the queue

	// Constructor to initialize the queue
	CircularQueueUsingArray(int size)
	{
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}

	// Function to add an element to the queue (enqueue operation)
	public void enqueue(int item)
	{
		// Check if the queue is full
		if (isFull())
		{
			System.out.println("Queue is full. Cannot add more elements.");
			return;
		}
		// Circular queue implementation
		rear = (rear + 1) % capacity;
		System.out.println("Rear : "+rear);
		arr[rear] = item;
		count++;
		System.out.println("Enqueued " + item);
	}

	// Function to remove an element from the queue (dequeue operation)
	public int dequeue()
	{
		// Check if the queue is empty
		if (isEmpty())
		{
			System.out.println("Queue is empty. Cannot dequeue.");
			return -1;
		}
		int item = arr[front];
		front = (front + 1) % capacity;
		System.out.println("Front : "+front);
		count--;
		System.out.println("Dequeued " + item);
		return item;
	}

	// Function to get the front element of the queue
	public int peek()
	{
		// Check if the queue is empty
		if (isEmpty())
		{
			System.out.println("Queue is empty.");
			return -1;
		}
		return arr[front];
	}

	// Function to check if the queue is empty
	public boolean isEmpty()
	{
		return count == 0;
	}

	// Function to check if the queue is full
	public boolean isFull()
	{
		return count == capacity;
	}

	// Function to get the current size of the queue
	public int size()
	{
		return count;
	}
	
	// Function to display all elements of the queue
	public void display()
	{
	    if (isEmpty())
	    {
	        System.out.println("Queue is empty.");
	        return;
	    }

	    System.out.print("Queue elements are: ");
	    int i = front;
	    for (int count = 0; count < this.count; count++)
	    {
	        System.out.print(arr[i] + " ");
	        i = (i + 1) % capacity;  // Move to the next element in a circular manner
	    }
	    System.out.println();
	}

	// Main method to test the queue implementation
	public static void main(String[] args)
	{
		CircularQueueUsingArray queue = new CircularQueueUsingArray(5);  // Create a queue with a capacity of 5

		queue.enqueue(1);  // Enqueue elements
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println("Front element is: " + queue.peek());  // Peek front element

		//queue.dequeue();  // Dequeue elements
		//queue.dequeue();

		System.out.println("Front element is: " + queue.peek());

		queue.enqueue(6);  // Enqueue additional element

		System.out.println("Queue size is: " + queue.size());  // Get current queue size

		//queue.dequeue();  // Dequeue more elements
		//queue.dequeue();
		//queue.dequeue();

		if (queue.isEmpty())
		{
			System.out.println("Queue is empty.");
		}
		else
		{
			System.out.println("Queue is not empty.");
		}
		
		queue.display();
	}
}